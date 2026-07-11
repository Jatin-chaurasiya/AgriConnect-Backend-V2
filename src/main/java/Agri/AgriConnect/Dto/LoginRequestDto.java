package Agri.AgriConnect.Dto;

import Agri.AgriConnect.Enum.Role;
import lombok.Data;

@Data
public class LoginRequestDto {
    private String email;
    private String password;
    private Role role;
}
