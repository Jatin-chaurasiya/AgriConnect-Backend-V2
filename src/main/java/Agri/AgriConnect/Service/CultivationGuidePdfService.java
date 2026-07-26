package Agri.AgriConnect.Service;

import Agri.AgriConnect.Dto.CropPlannerResponseDto;

public interface CultivationGuidePdfService {

    byte[] generatePdf(CropPlannerResponseDto dto);

}