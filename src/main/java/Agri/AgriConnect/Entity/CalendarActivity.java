package Agri.AgriConnect.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_calendar_activity")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CalendarActivity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "activity_id")
    private Long id;

    @Column(name = "day_number", nullable = false)
    private Integer dayNumber;

    @Column(name = "activity", nullable = false)
    private String activity;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    // ================= Relationship =================

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "crop_id", nullable = false)
    private Crop crop;

}