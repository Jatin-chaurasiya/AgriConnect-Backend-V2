package Agri.AgriConnect.Dto;

import lombok.Data;

@Data
public class ProfileDto {
    private String username;
    private String email;
    private String role;
    private String language;
    private String profileImageUrl;
}
