package Agri.AgriConnect.Implementation;

import Agri.AgriConnect.Dto.ProfileDto;
import Agri.AgriConnect.Entity.ProfileEntity;
import Agri.AgriConnect.Repository.ProfileRepository;
import Agri.AgriConnect.Service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileServiceImpl implements ProfileService{

    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public ProfileDto getProfileByEmail(String email){
        ProfileEntity profileEntity = profileRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Profile not found"));
        return maptoDto(profileEntity);
    }
    public ProfileDto updateProfile(String email,ProfileDto profileDto){
        ProfileEntity entity =  profileRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Profile not found"));
        entity.setUsername(profileDto.getUsername());
        entity.setEmail(profileDto.getEmail());
        entity.setLanguage(profileDto.getLanguage());
        entity.setProfileImageUrl(profileDto.getProfileImageUrl());

        ProfileEntity update = profileRepository.save(entity);
        return maptoDto(update);
    }

    public ProfileDto maptoDto(ProfileEntity entity){
        ProfileDto dto = new ProfileDto();
        dto.setUsername(entity.getUsername());
        dto.setEmail(entity.getEmail());
        dto.setLanguage(entity.getLanguage());
        dto.setRole(entity.getRole());
        dto.setProfileImageUrl(entity.getProfileImageUrl());
        return dto;
    }
}
