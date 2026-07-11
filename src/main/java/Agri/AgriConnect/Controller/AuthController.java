package Agri.AgriConnect.Controller;

import Agri.AgriConnect.Dto.AuthResponseDto;
import Agri.AgriConnect.Dto.LoginRequestDto;
import Agri.AgriConnect.Dto.MessageResponseDto;
import Agri.AgriConnect.Dto.RegisterRequestDto;
import Agri.AgriConnect.Service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<MessageResponseDto> register(
            @RequestBody RegisterRequestDto request) {

        return ResponseEntity.ok(
                authService.register(request)
        );
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDto> login(@RequestBody LoginRequestDto request) {
        AuthResponseDto response = authService.login(request);
        return ResponseEntity.ok(response);
    }
}
