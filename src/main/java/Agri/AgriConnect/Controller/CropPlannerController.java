package Agri.AgriConnect.Controller;

import Agri.AgriConnect.Dto.CropPlannerRequestDto;
import Agri.AgriConnect.Dto.CropPlannerResponseDto;
import Agri.AgriConnect.Service.CropPlannerPdfService;
import Agri.AgriConnect.Service.CropPlannerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import Agri.AgriConnect.Service.CultivationGuidePdfService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
@RestController
@RequestMapping("/crop-planner")
@RequiredArgsConstructor
public class CropPlannerController {

    private final CropPlannerService cropPlannerService;
    private final CropPlannerPdfService cropPlannerPdfService;
    private final CultivationGuidePdfService cultivationGuidePdfService;

    @PostMapping
    public ResponseEntity<CropPlannerResponseDto> getCropPlanner(
            @Valid @RequestBody CropPlannerRequestDto requestDto) {

        CropPlannerResponseDto response =
                cropPlannerService.getCropPlan(requestDto);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/export")
    public ResponseEntity<byte[]> exportCropPlanner(
            @RequestParam String cropName) {

        CropPlannerRequestDto requestDto = new CropPlannerRequestDto();
        requestDto.setCropName(cropName);

        CropPlannerResponseDto responseDto =
                cropPlannerService.getCropPlan(requestDto);

        byte[] pdf =
                cropPlannerPdfService.generatePdf(responseDto);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=" + cropName + "-Crop-Planner.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .contentLength(pdf.length)
                .body(pdf);
    }
    @GetMapping("/guide/export")
    public ResponseEntity<byte[]> exportCultivationGuide(
            @RequestParam String cropName) {

        CropPlannerRequestDto requestDto = new CropPlannerRequestDto();
        requestDto.setCropName(cropName);

        CropPlannerResponseDto responseDto =
                cropPlannerService.getCropPlan(requestDto);

        byte[] pdf =
                cultivationGuidePdfService.generatePdf(responseDto);

        return ResponseEntity.ok()
                .header(
                        HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=" +
                                cropName + "-Cultivation-Guide.pdf"
                )
                .contentType(MediaType.APPLICATION_PDF)
                .contentLength(pdf.length)
                .body(pdf);

    }
}