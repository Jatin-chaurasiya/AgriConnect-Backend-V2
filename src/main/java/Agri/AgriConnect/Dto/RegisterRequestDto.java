package Agri.AgriConnect.Dto;

import Agri.AgriConnect.Enum.Role;
import lombok.Data;

@Data
public class RegisterRequestDto {
    private String username;
    private String email;
    private String password;
    private String language;
    private String profileImageUrl;
    private Role role;
    private String businessName;
    private String phone;
    private String address;
}

