package Agri.AgriConnect.Implementation;

import Agri.AgriConnect.Dto.DeleteAccountRequestDto;
import Agri.AgriConnect.Dto.DeleteAccountResponseDto;
import Agri.AgriConnect.Entity.tbl_profiles;
import Agri.AgriConnect.Entity.tbl_provider_details;
import Agri.AgriConnect.Enum.BookingStatus;
import Agri.AgriConnect.Repository.BookingRepository;
import Agri.AgriConnect.Repository.ProfileRepository;
import Agri.AgriConnect.Repository.ProviderDetailsRepository;
import Agri.AgriConnect.Repository.ServiceRepository;
import Agri.AgriConnect.Service.DeleteProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class DeleteProfileServiceImpl implements DeleteProfileService {

    private final ProfileRepository profileRepository;
    private final ProviderDetailsRepository providerDetailsRepository;
    private final BookingRepository bookingRepository;
    private final ServiceRepository serviceRepository;

    @Override
    public DeleteAccountResponseDto deleteFarmerAccount(
            String email,
            DeleteAccountRequestDto request) {

        if (!"DELETE".equalsIgnoreCase(request.getConfirmation().trim())) {
            return new DeleteAccountResponseDto(false,
                    "Please type DELETE to confirm.");
        }

        tbl_profiles farmer = profileRepository.findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException("Farmer not found."));

        // Delete all bookings of farmer
        bookingRepository.deleteByFarmer(farmer);

        // Delete farmer profile
        profileRepository.delete(farmer);

        return new DeleteAccountResponseDto(
                true,
                "Farmer account deleted successfully."
        );
    }
    @Override
    public DeleteAccountResponseDto deleteProviderAccount(
            String email,
            DeleteAccountRequestDto request) {

        if (!"DELETE".equalsIgnoreCase(request.getConfirmation().trim())) {
            return new DeleteAccountResponseDto(false,
                    "Please type DELETE to confirm.");
        }

        tbl_profiles profile = profileRepository.findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException("Profile not found."));

        tbl_provider_details provider = providerDetailsRepository
                .findByProfile(profile)
                .orElseThrow(() ->
                        new RuntimeException("Provider not found."));

        // Check active bookings
        boolean activeBooking = bookingRepository.existsByProviderAndStatusIn(
                provider,
                List.of(
                        BookingStatus.PENDING,
                        BookingStatus.ACCEPTED
                )
        );

        if (activeBooking) {
            return new DeleteAccountResponseDto(
                    false,
                    "Cannot delete account because active bookings exist."
            );
        }

        // Delete completed / rejected / cancelled bookings
        bookingRepository.deleteByProvider(provider);

        // Delete provider services
        serviceRepository.deleteByProvider(provider);

        // Delete provider details
        providerDetailsRepository.delete(provider);

        // Delete profile
        profileRepository.delete(profile);

        return new DeleteAccountResponseDto(
                true,
                "Provider account deleted successfully."
        );
    }
}