package Agri.AgriConnect.Controller;

import Agri.AgriConnect.Dto.CropPlannerRequestDto;
import Agri.AgriConnect.Dto.CropPlannerResponseDto;
import Agri.AgriConnect.Service.CropPlannerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/crop-planner")
@RequiredArgsConstructor
public class CropPlannerController {

    private final CropPlannerService cropPlannerService;

    @PostMapping
    public ResponseEntity<CropPlannerResponseDto> getCropPlanner(
            @Valid @RequestBody CropPlannerRequestDto requestDto) {

        CropPlannerResponseDto response =
                cropPlannerService.getCropPlan(requestDto);

        return ResponseEntity.ok(response);
    }

}