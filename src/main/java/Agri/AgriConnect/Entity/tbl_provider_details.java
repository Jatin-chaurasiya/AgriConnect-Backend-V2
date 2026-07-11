package Agri.AgriConnect.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_provider_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class tbl_provider_details {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relation with tbl_profiles
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id", nullable = false, unique = true)
    private tbl_profiles profile;

    @Column(nullable = false)
    private String businessName;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private Boolean verified = false;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}