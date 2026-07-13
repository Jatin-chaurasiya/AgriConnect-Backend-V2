package Agri.AgriConnect.Controller;

import Agri.AgriConnect.Dto.ServiceResponseDto;
import Agri.AgriConnect.Service.ServiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/services")
@RequiredArgsConstructor
public class FarmerServiceController {

    private final ServiceService serviceService;
    @GetMapping
    public ResponseEntity<Page<ServiceResponseDto>> getAllServices(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size,
            @RequestParam(defaultValue = "") String keyword

    ) {
        return ResponseEntity.ok(
                serviceService.getAllServices(
                        page,
                        size,
                        keyword
                )
        );
    }
    @GetMapping("/{id}")
    public ResponseEntity<ServiceResponseDto> getServiceById(
            @PathVariable Long id) {
        return ResponseEntity.ok(serviceService.getServiceById(id));
    }
}