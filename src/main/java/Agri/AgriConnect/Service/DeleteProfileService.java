package Agri.AgriConnect.Service;

import Agri.AgriConnect.Dto.DeleteAccountRequestDto;
import Agri.AgriConnect.Dto.DeleteAccountResponseDto;

public interface DeleteProfileService {

    DeleteAccountResponseDto deleteFarmerAccount(
            String email,
            DeleteAccountRequestDto request
    );

    DeleteAccountResponseDto deleteProviderAccount(
            String email,
            DeleteAccountRequestDto request
    );

}