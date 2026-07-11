package Agri.AgriConnect.Dto;

import Agri.AgriConnect.Enum.Role;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthResponseDto {
    private String token;
    private String username;
    private Role role;
}
