package Agri.AgriConnect.Controller;

import Agri.AgriConnect.Dto.ServiceRequestDto;
import Agri.AgriConnect.Dto.ServiceResponseDto;
import Agri.AgriConnect.Service.ServiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/provider")
@RequiredArgsConstructor
public class ProviderServiceController {

    private final ServiceService serviceService;

    @PostMapping("/addService")
    public ResponseEntity<ServiceResponseDto> addService(
            @RequestBody ServiceRequestDto request) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(serviceService.addService(request));
    }
    @GetMapping("/myServices")
    public ResponseEntity<Page<ServiceResponseDto>> getMyServices(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size,
            @RequestParam(defaultValue = "") String keyword
    ) {
        return ResponseEntity.ok(
                serviceService.getMyServices(page, size, keyword));
    }
    @PutMapping("/updateService/{id}")
    public ResponseEntity<ServiceResponseDto> updateService(
            @PathVariable Long id,
            @RequestBody ServiceRequestDto request) {

        return ResponseEntity.ok(serviceService.updateService(id, request));
    }
    @DeleteMapping("/deleteService/{id}")
    public ResponseEntity<String> deleteService(@PathVariable Long id) {

        serviceService.deleteService(id);

        return ResponseEntity.ok("Service deleted successfully.");
    }
}