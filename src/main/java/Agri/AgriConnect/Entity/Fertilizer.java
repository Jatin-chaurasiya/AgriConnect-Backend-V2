package Agri.AgriConnect.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_fertilizer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Fertilizer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fertilizer_id")
    private Long id;

    @Column(name = "stage", nullable = false)
    private String stage;

    @Column(name = "day_number")
    private Integer dayNumber;

    @Column(name = "fertilizer_name", nullable = false)
    private String fertilizerName;

    @Column(name = "quantity")
    private Double quantity;

    @Column(name = "unit")
    private String unit;

    @Column(name = "purpose")
    private String purpose;

    // ================= Relationship =================

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "crop_id", nullable = false)
    private Crop crop;

}