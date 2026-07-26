package Agri.AgriConnect.Service;

import Agri.AgriConnect.Dto.CropPlannerResponseDto;

public interface CropPlannerPdfService {

    byte[] generatePdf(CropPlannerResponseDto dto);

}