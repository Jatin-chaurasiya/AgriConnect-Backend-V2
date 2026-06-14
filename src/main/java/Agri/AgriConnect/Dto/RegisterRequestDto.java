package Agri.AgriConnect.Dto;

import lombok.Data;

@Data
public class RegisterRequestDto {
    private String username;
    private String email;
    private String password;
    private String language;
    private String profileImageUrl;
    private String role;
}

