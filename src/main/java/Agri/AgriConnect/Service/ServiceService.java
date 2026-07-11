package Agri.AgriConnect.Service;

import Agri.AgriConnect.Dto.ServiceRequestDto;
import Agri.AgriConnect.Dto.ServiceResponseDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ServiceService {

    ServiceResponseDto addService(ServiceRequestDto request);

    Page<ServiceResponseDto> getMyServices(
            int page,
            int size,
            String keyword
    );
    Page<ServiceResponseDto> getAllServices(
            int page,
            int size,
            String keyword
    );
    ServiceResponseDto getServiceById(Long id);
    ServiceResponseDto updateService(Long id, ServiceRequestDto request);
    void deleteService(Long id);
}