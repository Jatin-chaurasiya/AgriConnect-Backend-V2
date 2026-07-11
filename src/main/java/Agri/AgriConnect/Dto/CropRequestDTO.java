package Agri.AgriConnect.Dto;

import lombok.Data;

@Data
public class CropRequestDTO {

    private Double nitrogen;
    private Double phosphorus;
    private Double potassium;
    private Double temperature;
    private Double humidity;
    private Double ph;
    private Double rainfall;
}