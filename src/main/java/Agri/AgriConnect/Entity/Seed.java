package Agri.AgriConnect.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_seed")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Seed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seed_id")
    private Long id;

    @Column(name = "variety", nullable = false)
    private String variety;

    @Column(name = "seed_rate")
    private String seedRate;

    @Column(name = "spacing")
    private String spacing;

    @Column(name = "germination")
    private String germination;

    @Column(name = "approx_cost")
    private Double approxCost;

    // ================= Relationship =================

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "crop_id", nullable = false)
    private Crop crop;

}