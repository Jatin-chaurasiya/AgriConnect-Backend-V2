package Agri.AgriConnect.Service;

import Agri.AgriConnect.Dto.ProfileDto;

public interface ProfileService {

    ProfileDto getProfileByEmail(String email);

    ProfileDto updateProfile(String email, ProfileDto profileDto);
}
