package Agri.AgriConnect.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_yield")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Yield {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "yield_id")
    private Long id;

    @Column(name = "state", nullable = false)
    private String state;

    @Column(name = "region")
    private String region;

    @Column(name = "expected_yield")
    private Double expectedYield;

    @Column(name = "yield_unit")
    private String yieldUnit;

    @Column(name = "market_price")
    private Double marketPrice;

    @Column(name = "price_unit")
    private String priceUnit;

    @Column(name = "expected_income")
    private Double expectedIncome;

    @Column(name = "expected_profit")
    private Double expectedProfit;

    // ================= Relationship =================

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "crop_id", nullable = false)
    private Crop crop;

}