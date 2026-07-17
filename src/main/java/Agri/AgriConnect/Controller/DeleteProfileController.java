package Agri.AgriConnect.Controller;

import Agri.AgriConnect.Dto.DeleteAccountRequestDto;
import Agri.AgriConnect.Dto.DeleteAccountResponseDto;
import Agri.AgriConnect.Service.DeleteProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profile")
@RequiredArgsConstructor
public class DeleteProfileController {

    private final DeleteProfileService deleteProfileService;

    @DeleteMapping("/farmer/delete-account")
    public ResponseEntity<DeleteAccountResponseDto> deleteFarmerAccount(
            @RequestBody DeleteAccountRequestDto request,
            Authentication authentication) {

        DeleteAccountResponseDto response =
                deleteProfileService.deleteFarmerAccount(
                        authentication.getName(),
                        request
                );

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/provider/delete-account")
    public ResponseEntity<DeleteAccountResponseDto> deleteProviderAccount(
            @RequestBody DeleteAccountRequestDto request,
            Authentication authentication) {

        DeleteAccountResponseDto response =
                deleteProfileService.deleteProviderAccount(
                        authentication.getName(),
                        request
                );

        return ResponseEntity.ok(response);
    }
}