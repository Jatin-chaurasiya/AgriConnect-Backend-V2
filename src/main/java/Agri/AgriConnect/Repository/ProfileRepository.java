package Agri.AgriConnect.Repository;

import Agri.AgriConnect.Entity.ProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfileRepository extends JpaRepository<ProfileEntity, Long> {

    Optional<ProfileEntity> findByEmail(String email);

    Optional<ProfileEntity> findByUsername(String username);

    boolean existsByEmail(String email);

    boolean existsByUsername(String username);

}
