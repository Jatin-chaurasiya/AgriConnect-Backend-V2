package Agri.AgriConnect.Dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CropPlannerRequestDto {

    @NotBlank(message = "Crop name is required")
    private String cropName;

}