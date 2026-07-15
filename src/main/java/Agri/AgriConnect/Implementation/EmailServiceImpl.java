package Agri.AgriConnect.Implementation;

import Agri.AgriConnect.Entity.Booking;
import Agri.AgriConnect.Service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender mailSender;

    @Override
    public void sendTestEmail(String to) {

        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(to);
            message.setSubject("Test Mail");
            message.setText("Hello from AgriConnect");
            mailSender.send(message);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
    @Override
    public void sendBookingAcceptedEmail(Booking booking) {

        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(booking.getFarmer().getEmail());

        message.setSubject("Booking Accepted | AgriConnect");
        message.setText(

                "Dear " + booking.getFarmerName() + ",\n\n"

                        + "We are pleased to inform you that your service booking has been successfully ACCEPTED by the service provider.\n\n"

                        + "Booking Details:\n"
                        + "---------------------------------\n"
                        + "Provider      : " + booking.getProvider().getBusinessName() + "\n"
                        + "Service       : " + booking.getService().getServiceName() + "\n"
                        + "Booking Date  : " + booking.getBookingDate() + "\n"
                        + "Booking Time  : " + booking.getBookingTime() + "\n"
                        + "---------------------------------\n\n"

                        + "Please ensure that you are available at the scheduled date and time. "
                        + "The provider will arrive as per the booking schedule to deliver the requested service.\n\n"

                        + "If you have any questions or need to make changes to your booking, "
                        + "please contact the service provider through AgriConnect before the scheduled time.\n\n"

                        + "Thank you for choosing AgriConnect. We look forward to serving you and wish you a successful farming season.\n\n"

                        + "Best Regards,\n"
                        + booking.getProvider().getBusinessName() + "\n"
                        + "via AgriConnect"

        );

        mailSender.send(message);
    }

    @Override
    public void sendBookingRejectedEmail(
            Booking booking,
            String reason) {

        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(booking.getFarmer().getEmail());

        message.setSubject("Booking Rejected | AgriConnect");

        message.setText(

                "Dear " + booking.getFarmerName() + ",\n\n"

                        + "Unfortunately your booking has been REJECTED.\n\n"

                        + "Provider : "
                        + booking.getProvider().getBusinessName() + "\n"

                        + "Service : "
                        + booking.getService().getServiceName() + "\n\n"

                        + "Reason :\n"
                        + reason + "\n\n"

                        + "Please book another available slot.\n\n"

                        + "Regards,\n"
                        + booking.getProvider().getBusinessName()

        );

        mailSender.send(message);
    }

    @Override
    public void sendBookingCompletedEmail(Booking booking) {

        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(booking.getFarmer().getEmail());

        message.setSubject("Service Completed | AgriConnect");

        message.setText(

                "Dear " + booking.getFarmerName() + ",\n\n"

                        + "We are happy to inform you that your booked service has been completed successfully.\n\n"

                        + "Service Details:\n"
                        + "---------------------------------\n"
                        + "Provider      : " + booking.getProvider().getBusinessName() + "\n"
                        + "Service       : " + booking.getService().getServiceName() + "\n"
                        + "Booking Date  : " + booking.getBookingDate() + "\n"
                        + "Booking Time  : " + booking.getBookingTime() + "\n"
                        + "---------------------------------\n\n"

                        + "We hope the service met your expectations and contributed to your farming needs.\n\n"

                        + "Thank you for choosing AgriConnect. Your trust motivates us to continue connecting farmers with reliable service providers.\n\n"

                        + "We look forward to serving you again in the future.\n\n"

                        + "Best Regards,\n"
                        + booking.getProvider().getBusinessName() + "\n"
                        + "via AgriConnect"

        );

        mailSender.send(message);
    }
    @Override
    public void sendBookingReceivedEmail(
            Booking booking) {

        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(booking.getFarmer().getEmail());

        message.setSubject("Booking Request Received | AgriConnect");

        message.setText(

                "Dear " + booking.getFarmerName() + ",\n\n"

                        + "Thank you for booking a service through AgriConnect.\n\n"

                        + "Your booking request has been received successfully.\n\n"

                        + "Booking Details:\n"
                        + "---------------------------------\n"
                        + "Provider      : " + booking.getProvider().getBusinessName() + "\n"
                        + "Service       : " + booking.getService().getServiceName() + "\n"
                        + "Booking Date  : " + booking.getBookingDate() + "\n"
                        + "Booking Time  : " + booking.getBookingTime() + "\n"
                        + "Status        : UNDER REVIEW\n"
                        + "---------------------------------\n\n"

                        + "Our service provider will review your booking shortly.\n"

                        + "You will receive another email once your booking is accepted or rejected.\n\n"

                        + "Thank you for choosing AgriConnect.\n\n"

                        + "Regards,\n"
                        + "AgriConnect Team"

        );

        mailSender.send(message);
    }
    @Override
    public void sendProviderRegistrationEmail(
            String to,
            String providerName) {

        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(to);

        message.setSubject("Welcome to AgriConnect | Provider Registration Successful");

        message.setText(

                "Dear " + providerName + ",\n\n"

                        + "Welcome to AgriConnect!\n\n"

                        + "Your Provider account has been registered successfully.\n\n"

                        + "You can now:\n"
                        + "• Add Agricultural Services\n"
                        + "• Manage Booking Requests\n"
                        + "• Accept or Reject Bookings\n"
                        + "• Complete Services\n"
                        + "• Grow Your Agricultural Business\n\n"

                        + "Thank you for partnering with AgriConnect.\n\n"

                        + "We wish you continued success.\n\n"

                        + "Regards,\n"
                        + "AgriConnect Team"

        );

        mailSender.send(message);
    }
    @Override
    public void sendFarmerRegistrationEmail(
            String to,
            String farmerName) {

        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(to);

        message.setSubject("Welcome to AgriConnect | Farmer Registration Successful");

        message.setText(

                "Dear " + farmerName + ",\n\n"

                        + "Welcome to AgriConnect!\n\n"

                        + "Your Farmer account has been created successfully.\n\n"

                        + "With AgriConnect you can:\n"
                        + "• Explore Agricultural Services\n"
                        + "• Book Trusted Service Providers\n"
                        + "• Get Weather Updates\n"
                        + "• View Government Schemes\n"
                        + "• Receive Booking Notifications\n\n"

                        + "Thank you for joining AgriConnect.\n\n"

                        + "We wish you a successful farming journey.\n\n"

                        + "Regards,\n"
                        + "AgriConnect Team"

        );

        mailSender.send(message);
    }
}