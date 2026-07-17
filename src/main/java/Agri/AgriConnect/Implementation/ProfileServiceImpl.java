package Agri.AgriConnect.Implementation;

import Agri.AgriConnect.Dto.BecomeProviderRequestDto;
import Agri.AgriConnect.Dto.BecomeProviderResponseDto;
import Agri.AgriConnect.Dto.ProfileDto;
import Agri.AgriConnect.Entity.tbl_profiles;
import Agri.AgriConnect.Entity.tbl_provider_details;
import Agri.AgriConnect.Repository.ProfileRepository;
import Agri.AgriConnect.Repository.ProviderDetailsRepository;
import Agri.AgriConnect.Service.EmailService;
import Agri.AgriConnect.Service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileServiceImpl implements ProfileService{

    @Autowired
    private ProfileRepository profileRepository;
    @Autowired
    private ProviderDetailsRepository providerDetailsRepository;
    @Autowired
    private EmailService emailService;

    @Override
    public ProfileDto getProfileByEmail(String email){
        tbl_profiles profileEntity = profileRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Profile not found"));
        return maptoDto(profileEntity);
    }
    public ProfileDto updateProfile(String email,ProfileDto profileDto){
        tbl_profiles entity =  profileRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Profile not found"));
        entity.setUsername(profileDto.getUsername());
        entity.setEmail(profileDto.getEmail());
        entity.setLanguage(profileDto.getLanguage());
        entity.setProfileImageUrl(profileDto.getProfileImageUrl());

        tbl_profiles update = profileRepository.save(entity);
        return maptoDto(update);
    }
    @Override
    public BecomeProviderResponseDto becomeProvider(String email,
                                                    BecomeProviderRequestDto request) {
        tbl_profiles profile = profileRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Profile not found"));

        if (providerDetailsRepository.findByProfile(profile).isPresent()) {
            return new BecomeProviderResponseDto(
                    false,
                    "You are already registered as a provider."
            );
        }
        tbl_provider_details provider = new tbl_provider_details();
        provider.setProfile(profile);
        provider.setBusinessName(request.getBusinessName());
        provider.setPhone(request.getPhone());
        provider.setAddress(request.getAddress());
        provider.setVerified(false);

        providerDetailsRepository.save(provider);
        return new BecomeProviderResponseDto(
                true,
                "Provider application submitted successfully. It is under admin review."
        );
    }

    public ProfileDto maptoDto(tbl_profiles entity){
        ProfileDto dto = new ProfileDto();
        dto.setUsername(entity.getUsername());
        dto.setEmail(entity.getEmail());
        dto.setLanguage(entity.getLanguage());
        dto.setRole(entity.getRole());
        dto.setProfileImageUrl(entity.getProfileImageUrl());
        return dto;
    }
}
