package Agri.AgriConnect.Entity;

import Agri.AgriConnect.Enum.Category;
import Agri.AgriConnect.Enum.SchemeType;
import Agri.AgriConnect.Enum.State;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "schemes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Scheme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Scheme name is required")
    private String name;

    @NotBlank(message = "Description is required")
    @Column(length = 1000)
    private String description;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Type is required")
    private SchemeType type;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "State is required")
    private State state;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Category is required")
    private Category category;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "apply_link")
    private String applyLink;

    @Column(columnDefinition = "TEXT")
    private String process;

    @Column(columnDefinition = "TEXT")
    private String eligibility;

    @Column(columnDefinition = "TEXT")
    private String benefits;
}