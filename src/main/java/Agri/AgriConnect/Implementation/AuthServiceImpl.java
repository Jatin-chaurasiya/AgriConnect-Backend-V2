package Agri.AgriConnect.Implementation;


import Agri.AgriConnect.Dto.AuthResponseDto;
import Agri.AgriConnect.Dto.LoginRequestDto;
import Agri.AgriConnect.Dto.MessageResponseDto;
import Agri.AgriConnect.Dto.RegisterRequestDto;
import Agri.AgriConnect.Entity.ProfileEntity;
import Agri.AgriConnect.Repository.ProfileRepository;
import Agri.AgriConnect.Service.AuthService;
import Agri.AgriConnect.Util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final ProfileRepository profileRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    @Override
    public MessageResponseDto register(RegisterRequestDto request) {

        if (profileRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        if (profileRepository.existsByUsername(request.getUsername())) {
            throw new RuntimeException("Username already exists");
        }

        ProfileEntity profile = ProfileEntity.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .language(request.getLanguage())
                .role(request.getRole())
                .profileImageUrl(request.getProfileImageUrl())
                .build();


        profileRepository.save(profile);

        return new MessageResponseDto("User registered successfully");
    }

    @Override
    public AuthResponseDto login(LoginRequestDto request) {

        ProfileEntity profile = profileRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid email or password"));

        if (!passwordEncoder.matches(request.getPassword(), profile.getPassword())) {
            throw new RuntimeException("Invalid email or password");
        }

        String token = jwtUtil.generateToken(profile.getEmail());

        return new AuthResponseDto(
                token,
                profile.getUsername(),
                profile.getRole()
        );
    }
}
