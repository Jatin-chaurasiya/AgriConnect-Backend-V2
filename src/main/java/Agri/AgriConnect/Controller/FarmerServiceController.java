package Agri.AgriConnect.Controller;

import Agri.AgriConnect.Dto.ServiceResponseDto;
import Agri.AgriConnect.Service.ServiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/services")
@RequiredArgsConstructor
public class FarmerServiceController {

    private final ServiceService serviceService;

    @GetMapping
    public ResponseEntity<List<ServiceResponseDto>> getAllServices() {

        return ResponseEntity.ok(serviceService.getAllServices());
    }
    @GetMapping("/{id}")
    public ResponseEntity<ServiceResponseDto> getServiceById(
            @PathVariable Long id) {

        return ResponseEntity.ok(serviceService.getServiceById(id));
    }
}