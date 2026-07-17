package Agri.AgriConnect.Dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteAccountRequestDto {

    @NotBlank(message = "Confirmation is required.")
    private String confirmation;

}