package Agri.AgriConnect.Repository;

import Agri.AgriConnect.Entity.Scheme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SchemeRepository extends JpaRepository<Scheme, Long>,
        JpaSpecificationExecutor<Scheme> {
}