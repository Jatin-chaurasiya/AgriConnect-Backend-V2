package Agri.AgriConnect.Repository;

import Agri.AgriConnect.Entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {

}