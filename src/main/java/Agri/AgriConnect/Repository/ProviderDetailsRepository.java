package Agri.AgriConnect.Repository;

import Agri.AgriConnect.Entity.tbl_profiles;
import Agri.AgriConnect.Entity.tbl_provider_details;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProviderDetailsRepository
        extends JpaRepository<tbl_provider_details, Long> {

    Optional<tbl_provider_details> findByProfile(tbl_profiles profile);

    void deleteByProfile(tbl_profiles profile);
}