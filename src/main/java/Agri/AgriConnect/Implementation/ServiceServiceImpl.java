package Agri.AgriConnect.Implementation;

import Agri.AgriConnect.Dto.ServiceRequestDto;
import Agri.AgriConnect.Dto.ServiceResponseDto;
import Agri.AgriConnect.Entity.ServiceEntity;
import Agri.AgriConnect.Entity.tbl_profiles;
import Agri.AgriConnect.Entity.tbl_provider_details;
import Agri.AgriConnect.Repository.ProfileRepository;
import Agri.AgriConnect.Repository.ProviderDetailsRepository;
import Agri.AgriConnect.Repository.ServiceRepository;
import Agri.AgriConnect.Service.ServiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceServiceImpl implements ServiceService {

    private final ServiceRepository serviceRepository;
    private final ProfileRepository profileRepository;
    private final ProviderDetailsRepository providerDetailsRepository;

    @Override
    public ServiceResponseDto addService(ServiceRequestDto request) {

        Authentication authentication = SecurityContextHolder
                .getContext()
                .getAuthentication();

        String email = authentication.getName();

        tbl_profiles profile = profileRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Profile not found"));

        tbl_provider_details provider = providerDetailsRepository
                .findByProfile(profile)
                .orElseThrow(() -> new RuntimeException("Provider details not found"));

        if(serviceRepository.findByProviderAndServiceNameIgnoreCase(provider,
                request.getServiceName()).isPresent()){

            throw new RuntimeException("Service already exists");
        }
        ServiceEntity service = convertToEntity(request, provider);

        ServiceEntity savedService = serviceRepository.save(service);

        return convertToResponse(savedService);
    }

    @Override
    public Page<ServiceResponseDto> getAllServices(
            int page,
            int size,
            String keyword
    ) {
        Pageable pageable = PageRequest.of(page, size);
        Page<ServiceEntity> services;
        if (keyword == null || keyword.trim().isEmpty()) {
            services =
                    serviceRepository.findByStatusTrueAndAvailabilityTrue(
                            pageable
                    );
        } else {

            services =
                    serviceRepository.searchServices(
                            keyword,
                            pageable
                    );

        }

        return services.map(this::convertToResponse);
    }
    @Override
    public Page<ServiceResponseDto> getMyServices(
            int page,
            int size,
            String keyword) {

        Authentication authentication = SecurityContextHolder
                .getContext()
                .getAuthentication();

        String email = authentication.getName();
        tbl_profiles profile = profileRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Profile not found"));

        tbl_provider_details provider = providerDetailsRepository
                .findByProfile(profile)
                .orElseThrow(() -> new RuntimeException("Provider not found"));
        Pageable pageable = PageRequest.of(page, size);
        Page<ServiceEntity> services;
        if (keyword == null || keyword.trim().isEmpty()) {
            services = serviceRepository.findByProvider(
                    provider,
                    pageable
            );
        } else {
            services = serviceRepository
                    .findByProviderAndServiceNameContainingIgnoreCase(
                            provider,
                            keyword,
                            pageable
                    );

        }
        return services.map(this::convertToResponse);
    }
    @Override
    public ServiceResponseDto getServiceById(Long id) {

        ServiceEntity service = serviceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Service not found"));

        return convertToResponse(service);
    }
    @Override
    public ServiceResponseDto updateService(Long id, ServiceRequestDto request) {

        Authentication authentication = SecurityContextHolder
                .getContext()
                .getAuthentication();

        String email = authentication.getName();

        tbl_profiles profile = profileRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Profile not found"));

        tbl_provider_details provider = providerDetailsRepository
                .findByProfile(profile)
                .orElseThrow(() -> new RuntimeException("Provider not found"));

        ServiceEntity service = serviceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Service not found"));

        // Security Check
        if (!service.getProvider().getId().equals(provider.getId())) {
            throw new RuntimeException("You are not authorized to update this service.");
        }

        service.setServiceName(request.getServiceName());
        service.setCategory(request.getCategory());
        service.setDescription(request.getDescription());
        service.setPrice(request.getPrice());
        service.setUnit(request.getUnit());
        service.setDistrict(request.getDistrict());
        service.setExperience(request.getExperience());
        service.setImageUrl(request.getImageUrl());
        service.setAvailability(request.getAvailability());

        ServiceEntity updatedService = serviceRepository.save(service);

        return convertToResponse(updatedService);
    }
    @Override
    public void deleteService(Long id) {

        Authentication authentication = SecurityContextHolder
                .getContext()
                .getAuthentication();

        String email = authentication.getName();

        tbl_profiles profile = profileRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Profile not found"));

        tbl_provider_details provider = providerDetailsRepository
                .findByProfile(profile)
                .orElseThrow(() -> new RuntimeException("Provider not found"));

        ServiceEntity service = serviceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Service not found"));

        // Security Check
        if (!service.getProvider().getId().equals(provider.getId())) {
            throw new RuntimeException("You are not authorized to delete this service.");
        }

        serviceRepository.delete(service);
    }

    //Helper Methods
    private ServiceEntity convertToEntity(ServiceRequestDto request,
                                          tbl_provider_details provider) {

        return ServiceEntity.builder()
                .provider(provider)
                .serviceName(request.getServiceName())
                .category(request.getCategory())
                .description(request.getDescription())
                .price(request.getPrice())
                .unit(request.getUnit())
                .district(request.getDistrict())
                .experience(request.getExperience())
                .imageUrl(request.getImageUrl())
                .availability(request.getAvailability())
                .status(true)
                .build();
    }

    private ServiceResponseDto convertToResponse(ServiceEntity service) {

        return ServiceResponseDto.builder()
                .id(service.getId())
                .serviceName(service.getServiceName())
                .category(service.getCategory())
                .description(service.getDescription())
                .price(service.getPrice())
                .unit(service.getUnit())
                .district(service.getDistrict())
                .experience(service.getExperience())
                .imageUrl(service.getImageUrl())
                .availability(service.getAvailability())
                .providerName(service.getProvider().getBusinessName())
                .build();
    }
}