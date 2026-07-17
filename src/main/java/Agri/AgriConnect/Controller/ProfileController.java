package Agri.AgriConnect.Controller;

import Agri.AgriConnect.Dto.BecomeProviderRequestDto;
import Agri.AgriConnect.Dto.BecomeProviderResponseDto;
import Agri.AgriConnect.Dto.ProfileDto;
import Agri.AgriConnect.Service.ProfileService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profile")
@RequiredArgsConstructor
public class ProfileController {

    private final ProfileService profileService;

    @GetMapping("/me")
    public ResponseEntity<ProfileDto> getProfile(Authentication authentication) {

        String email = authentication.getName();

        ProfileDto profile = profileService.getProfileByEmail(email);
        return ResponseEntity.ok(profile);
    }

    @PutMapping("/me")
    public ResponseEntity<ProfileDto> updateProfile(
            Authentication authentication,
            @RequestBody ProfileDto profileDto) {

        String email = authentication.getName();

        ProfileDto profile = profileService.updateProfile(email, profileDto);
        return ResponseEntity.ok(profile);
    }
    @PostMapping("/become-provider")
    public ResponseEntity<BecomeProviderResponseDto> becomeProvider(
            Authentication authentication,
            @Valid @RequestBody BecomeProviderRequestDto request) {

        String email = authentication.getName();

        BecomeProviderResponseDto response =
                profileService.becomeProvider(email, request);

        return ResponseEntity.ok(response);
    }

}
