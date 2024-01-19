package al.cherbourg_photographers.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name="adresse")
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "adresse_id")
    private int id;

    @Column(name = "num_voie", length = 6)
    private String streetNumber;

    @Column(name = "lib_voie", length = 100)
    private String streetName;

    @Column(name = "lib_ville", length = 20, nullable = false)
    private String cityName;

    @ManyToMany(mappedBy = "address")
    private List<WorkshopBackgroundEntity> backgroundEntities = new ArrayList<>();
}
