package Agri.AgriConnect.Repository;

import Agri.AgriConnect.Entity.Crop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CropRepository extends JpaRepository<Crop, Long> {

    /**
     * Find crop by its name (case-insensitive).
     * Example:
     * Rice, rice, RICE -> same result
     */
    Optional<Crop> findByCropNameIgnoreCase(String cropName);

}