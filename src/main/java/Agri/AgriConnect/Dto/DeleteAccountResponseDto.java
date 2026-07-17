package Agri.AgriConnect.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteAccountResponseDto {

    private boolean success;
    private String message;

}