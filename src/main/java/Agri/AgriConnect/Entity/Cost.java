package Agri.AgriConnect.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_cost")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cost_id")
    private Long id;

    @Column(name = "state", nullable = false)
    private String state;

    @Column(name = "region")
    private String region;

    @Column(name = "seed_cost")
    private Double seedCost;

    @Column(name = "fertilizer_cost")
    private Double fertilizerCost;

    @Column(name = "pesticide_cost")
    private Double pesticideCost;

    @Column(name = "labour_cost")
    private Double labourCost;

    @Column(name = "irrigation_cost")
    private Double irrigationCost;

    @Column(name = "harvesting_cost")
    private Double harvestingCost;

    @Column(name = "miscellaneous_cost")
    private Double miscellaneousCost;

    @Column(name = "total_cost")
    private Double totalCost;

    // ================= Relationship =================

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "crop_id", nullable = false)
    private Crop crop;

}