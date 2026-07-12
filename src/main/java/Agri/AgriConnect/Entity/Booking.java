package Agri.AgriConnect.Entity;

import Agri.AgriConnect.Enum.BookingStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "tbl_bookings")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Farmer
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "farmer_id", nullable = false)
    private tbl_profiles farmer;

    // Provider
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "provider_id", nullable = false)
    private tbl_provider_details provider;

    // Service
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "service_id", nullable = false)
    private ServiceEntity service;

    private String farmerName;

    private String mobile;

    private String village;

    private String address;

    private LocalDate bookingDate;

    private LocalTime bookingTime;

    @Column(length = 1000)
    private String note;

    @Enumerated(EnumType.STRING)
    private BookingStatus status;

    private LocalDateTime bookedAt;

    // Razorpay

    private String razorpayOrderId;

    private String razorpayPaymentId;

    private String paymentStatus;
}