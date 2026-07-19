package Agri.AgriConnect.Service;

import Agri.AgriConnect.Dto.CropPlannerRequestDto;
import Agri.AgriConnect.Dto.CropPlannerResponseDto;

public interface CropPlannerService {

    /**
     * Returns complete crop planning details
     * based on the recommended crop.
     */
    CropPlannerResponseDto getCropPlan(CropPlannerRequestDto requestDto);

}