package Agri.AgriConnect.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BecomeProviderRequestDto {

    @NotBlank(message = "Business Name is required.")
    private String businessName;

    @NotBlank(message = "Phone Number is required.")
    @Pattern(
            regexp = "^[6-9]\\d{9}$",
            message = "Enter a valid 10-digit phone number."
    )
    private String phone;

    @NotBlank(message = "Address is required.")
    private String address;
}