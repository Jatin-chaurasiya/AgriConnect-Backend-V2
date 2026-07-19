package Agri.AgriConnect.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_irrigation")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Irrigation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "irrigation_id")
    private Long id;

    @Column(name = "day_number")
    private String dayNumber;

    @Column(name = "stage", nullable = false)
    private String stage;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    // ================= Relationship =================

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "crop_id", nullable = false)
    private Crop crop;

}