package Agri.AgriConnect.Repository;

import Agri.AgriConnect.Entity.tbl_profiles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfileRepository extends JpaRepository<tbl_profiles, Long> {

    Optional<tbl_profiles> findByEmail(String email);

    Optional<tbl_profiles> findByUsername(String username);

    boolean existsByEmail(String email);

    boolean existsByUsername(String username);

}
