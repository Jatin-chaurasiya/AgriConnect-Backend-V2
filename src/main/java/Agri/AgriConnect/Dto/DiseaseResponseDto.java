package Agri.AgriConnect.Dto;

import lombok.Data;

@Data
public class DiseaseResponseDto {

    private Long id;
    private String diseaseName;
    private String symptoms;
    private String prevention;
    private String medicine;
    private String dosage;
    private String sprayInterval;

}