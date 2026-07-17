package Agri.AgriConnect.Repository;

import Agri.AgriConnect.Entity.Booking;
import Agri.AgriConnect.Entity.ServiceEntity;
import Agri.AgriConnect.Entity.tbl_profiles;
import Agri.AgriConnect.Entity.tbl_provider_details;
import Agri.AgriConnect.Enum.BookingStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    // ================= Farmer =================
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
    void deleteByFarmer(tbl_profiles farmer);

    // ================= Provider =================
    boolean existsByService(ServiceEntity service);
    Page<Booking> findByProviderAndStatusOrderByBookedAtDesc(
            tbl_provider_details provider,
            BookingStatus status,
            Pageable pageable
    );
    Page<Booking> findByProviderAndStatusInOrderByBookedAtDesc(
            tbl_provider_details provider,
            List<BookingStatus> status,
            Pageable pageable
    );
    Optional<Booking> findByIdAndProvider(
            Long bookingId,
            tbl_provider_details provider
    );
    void deleteByProvider(tbl_provider_details provider);
    boolean existsByProviderAndStatusIn(
            tbl_provider_details provider,
            List<BookingStatus> statuses
    );
}