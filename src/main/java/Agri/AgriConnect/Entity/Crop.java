package Agri.AgriConnect.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tbl_crop")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Crop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "crop_id")
    private Long id;

    @Column(name = "crop_name", nullable = false, unique = true)
    private String cropName;

    @Column(name = "scientific_name")
    private String scientificName;

    @Column(name = "crop_type")
    private String cropType;

    @Column(name = "season")
    private String season;

    @Column(name = "duration_days")
    private Integer durationDays;

    @Column(name = "ideal_temperature")
    private String idealTemperature;

    @Column(name = "ideal_humidity")
    private String idealHumidity;

    @Column(name = "ideal_ph")
    private String idealPh;

    @Column(name = "rainfall")
    private String rainfall;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    // ================= Relationships =================

    @OneToMany(mappedBy = "crop", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Seed> seeds = new ArrayList<>();

    @OneToMany(mappedBy = "crop", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Fertilizer> fertilizers = new ArrayList<>();

    @OneToMany(mappedBy = "crop", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Irrigation> irrigations = new ArrayList<>();

    @OneToMany(mappedBy = "crop", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Disease> diseases = new ArrayList<>();

    @OneToMany(mappedBy = "crop", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CalendarActivity> calendarActivities = new ArrayList<>();

    @OneToMany(mappedBy = "crop", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Yield> yields = new ArrayList<>();

    @OneToMany(mappedBy = "crop", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cost> costs = new ArrayList<>();

}