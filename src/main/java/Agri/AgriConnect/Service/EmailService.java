package Agri.AgriConnect.Service;

import Agri.AgriConnect.Entity.Booking;

public interface EmailService {

    void sendTestEmail(String to);

    // ================= Registration =================

    void sendFarmerRegistrationEmail(
            String to,
            String farmerName
    );

    void sendProviderRegistrationEmail(
            String to,
            String providerName
    );

    // ================= Booking =================

    void sendBookingReceivedEmail(
            Booking booking
    );

    void sendBookingAcceptedEmail(
            Booking booking
    );

    void sendBookingRejectedEmail(
            Booking booking,
            String reason
    );

    void sendBookingCompletedEmail(
            Booking booking
    );
}