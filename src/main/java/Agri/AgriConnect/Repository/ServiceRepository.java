package Agri.AgriConnect.Repository;

import Agri.AgriConnect.Entity.ServiceEntity;
import Agri.AgriConnect.Entity.tbl_provider_details;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

public interface ServiceRepository extends JpaRepository<ServiceEntity, Long> {

    List<ServiceEntity> findByProvider(tbl_provider_details provider);
    Page<ServiceEntity> findByProvider(
            tbl_provider_details provider,
            Pageable pageable);
    Page<ServiceEntity> findByProviderAndServiceNameContainingIgnoreCase(
            tbl_provider_details provider,
            String keyword,
            Pageable pageable);

    List<ServiceEntity> findByStatusTrue();
    Optional<ServiceEntity> findByProviderAndServiceNameIgnoreCase(
            tbl_provider_details provider,
            String serviceName
    );

}