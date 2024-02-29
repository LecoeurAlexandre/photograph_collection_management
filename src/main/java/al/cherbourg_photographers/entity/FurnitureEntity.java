package al.cherbourg_photographers.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name="mobilier")
public class FurnitureEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mobilier_id")
    private int id;

    @Column(name = "lib_mobilier", length = 50, nullable = false)
    private String FurnitureName;

    @Column(name="description_mobilier", length = 255, nullable = false)
    private String FurnitureDescription;
}
