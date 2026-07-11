package Agri.AgriConnect.Service;


import Agri.AgriConnect.Dto.ProfileDto;
import Agri.AgriConnect.Entity.tbl_profiles;
import Agri.AgriConnect.Implementation.ProfileServiceImpl;
import Agri.AgriConnect.Repository.ProfileRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class ProfileServiceTest {
    @Mock
    private ProfileRepository profileRepository;
    @InjectMocks
    private ProfileServiceImpl profileService;

    @Test
    void getProfileByEmailTest(){
        tbl_profiles entity = new tbl_profiles();
        entity.setUsername("Jatin");
        entity.setEmail("jatin@gmail.com");
        entity.setLanguage("English");
        entity.setRole("Farmer");
        entity.setProfileImageUrl("image.png");

        Mockito.when(profileRepository.findByEmail("jatin@gmail.com")).thenReturn(Optional.of(entity));

        ProfileDto dto = profileService.getProfileByEmail("jatin@gmail.com");

        Assertions.assertEquals("Jatin", dto.getUsername());
        Assertions.assertEquals("jatin@gmail.com", dto.getEmail());
        Assertions.assertEquals("English", dto.getLanguage());
        Assertions.assertEquals("Farmer", dto.getRole());
        Assertions.assertEquals("image.png", dto.getProfileImageUrl());

        Mockito.verify(profileRepository)
                .findByEmail("jatin@gmail.com");
    }
    @Test
    void updateProfileTest() {
        tbl_profiles entity = new tbl_profiles();
        entity.setUsername("Old Name");
        entity.setEmail("old@gmail.com");
        entity.setLanguage("Hindi");
        entity.setProfileImageUrl("old.png");

        ProfileDto dto = new ProfileDto();
        dto.setUsername("Jatin");
        dto.setEmail("jatin@gmail.com");
        dto.setLanguage("English");
        dto.setProfileImageUrl("new.png");

        Mockito.when(profileRepository.findByEmail("old@gmail.com"))
                .thenReturn(Optional.of(entity));

        Mockito.when(profileRepository.save(Mockito.any(tbl_profiles.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));


        ProfileDto result =
                profileService.updateProfile("old@gmail.com", dto);

        Assertions.assertEquals("Jatin", result.getUsername());
        Assertions.assertEquals("jatin@gmail.com", result.getEmail());
        Assertions.assertEquals("English", result.getLanguage());
        Assertions.assertEquals("new.png", result.getProfileImageUrl());

        Mockito.verify(profileRepository)
                .findByEmail("old@gmail.com");

        Mockito.verify(profileRepository)
                .save(Mockito.any(tbl_profiles.class));
    }

}