package Agri.AgriConnect.Service;

import Agri.AgriConnect.Entity.Booking;

public interface EmailService {

    void sendBookingAcceptedEmail(Booking booking);

    void sendBookingRejectedEmail(
            Booking booking,
            String reason
    );

    void sendBookingCompletedEmail(Booking booking);
    void sendTestEmail(String to);
}