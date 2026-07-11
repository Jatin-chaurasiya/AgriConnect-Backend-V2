package Agri.AgriConnect.Dto;

import Agri.AgriConnect.Enum.Role;
import lombok.Data;

@Data
public class ProfileDto {
    private String username;
    private String email;
    private Role role;
    private String language;
    private String profileImageUrl;
}
