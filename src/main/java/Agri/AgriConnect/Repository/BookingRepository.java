package Agri.AgriConnect.Repository;

import Agri.AgriConnect.Entity.Booking;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    Page<Booking> findByFarmerIdOrderByBookedAtDesc(
            Long farmerId,
            Pageable pageable
    );
    Page<Booking> findByFarmerIdAndService_ServiceNameContainingIgnoreCase(
            Long farmerId,
            String keyword,
            Pageable pageable
    );
    Optional<Booking> findByIdAndFarmerId(
            Long bookingId,
            Long farmerId
    );
}