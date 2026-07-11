package Agri.AgriConnect.Service;

import Agri.AgriConnect.Dto.AuthResponseDto;
import Agri.AgriConnect.Dto.LoginRequestDto;
import Agri.AgriConnect.Dto.MessageResponseDto;
import Agri.AgriConnect.Dto.RegisterRequestDto;

public interface AuthService {

    MessageResponseDto register(RegisterRequestDto request);

    AuthResponseDto login(LoginRequestDto request);
}
