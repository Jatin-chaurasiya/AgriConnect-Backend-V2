package Agri.AgriConnect.Implementation;


import Agri.AgriConnect.Dto.AuthResponseDto;
import Agri.AgriConnect.Dto.LoginRequestDto;
import Agri.AgriConnect.Dto.MessageResponseDto;
import Agri.AgriConnect.Dto.RegisterRequestDto;
import Agri.AgriConnect.Entity.tbl_profiles;
import Agri.AgriConnect.Enum.Role;
import Agri.AgriConnect.Repository.ProfileRepository;
import Agri.AgriConnect.Service.AuthService;
import Agri.AgriConnect.Service.EmailService;
import Agri.AgriConnect.Util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import Agri.AgriConnect.Entity.tbl_provider_details;
import Agri.AgriConnect.Repository.ProviderDetailsRepository;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final ProfileRepository profileRepository;
    private final ProviderDetailsRepository providerDetailsRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final EmailService emailService;

    @Override
    public MessageResponseDto register(RegisterRequestDto request) {
        if (request.getRole() == Role.FARMER) {

            request.setBusinessName(null);
            request.setPhone(null);
            request.setAddress(null);
        }

        if (request.getRole() == null) {
            throw new RuntimeException("Role is required.");
        }

        if (request.getRole() == Role.ADMIN) {
            throw new RuntimeException("Admin registration is not allowed.");
        }

        if (profileRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        if (profileRepository.existsByUsername(request.getUsername())) {
            throw new RuntimeException("Username already exists");
        }
        if (request.getRole() == Role.PROVIDER) {

            if (request.getBusinessName() == null || request.getBusinessName().isBlank()) {
                throw new RuntimeException("Business Name is required.");
            }

            if (request.getPhone() == null || request.getPhone().isBlank()) {
                throw new RuntimeException("Phone Number is required.");
            }

            if (request.getAddress() == null || request.getAddress().isBlank()) {
                throw new RuntimeException("Address is required.");
            }
        }

        tbl_profiles profile = tbl_profiles.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .language(request.getLanguage())
                .role(request.getRole())
                .profileImageUrl(request.getProfileImageUrl())
                .build();

        // Save profile first
        profile = profileRepository.save(profile);

        // If Provider, save provider details
        if (request.getRole() == Role.PROVIDER) {

            tbl_provider_details provider = tbl_provider_details.builder()
                    .profile(profile)
                    .businessName(request.getBusinessName())
                    .phone(request.getPhone())
                    .address(request.getAddress())
                    .verified(false)
                    .build();

            providerDetailsRepository.save(provider);
            // Send Provider Registration Email
            emailService.sendProviderRegistrationEmail(
                    profile.getEmail(),
                    provider.getBusinessName()
            );

        } else {

            // Send Farmer Registration Email
            emailService.sendFarmerRegistrationEmail(
                    profile.getEmail(),
                    profile.getUsername()
            );
        }
        return new MessageResponseDto("User registered successfully");
    }

    @Override
    public AuthResponseDto login(LoginRequestDto request) {

        tbl_profiles profile = profileRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid email or password"));

        if (!passwordEncoder.matches(request.getPassword(), profile.getPassword())) {
            throw new RuntimeException("Invalid email or password");
        }

        // Role Validation
        if (request.getRole() == Role.FARMER) {
            if (profile.getRole() != Role.FARMER) {
                throw new RuntimeException("This account is not registered as a Farmer.");
            }
        } else if (request.getRole() == Role.PROVIDER) {
            if (providerDetailsRepository.findByProfile(profile).isEmpty()) {
                throw new RuntimeException("This account is not registered as a Service Provider.");
            }
        } else if (request.getRole() == Role.ADMIN) {
            if (profile.getRole() != Role.ADMIN) {
                throw new RuntimeException("This account is not registered as an Admin.");
            }
        }

        String token = jwtUtil.generateToken(profile.getEmail());
        boolean isProvider =
                providerDetailsRepository.findByProfile(profile).isPresent();
        return new AuthResponseDto(
                token,
                profile.getUsername(),
                profile.getRole(),
                isProvider
        );
    }
}
