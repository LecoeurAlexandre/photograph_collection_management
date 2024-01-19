package al.cherbourg_photographers.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name="fond")
public class WorkshopBackgroundEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fond_id")
    private int id;

    @Column(name = "lib_fond_description", length = 255, nullable = false)
    private String backgroundDescription;

    @ManyToMany
    @JoinTable(
            name = "fonds_adresse",
            joinColumns = @JoinColumn(name = "fond_id"),
            inverseJoinColumns = @JoinColumn(name = "adresse_id"))
    private List<AddressEntity> address = new ArrayList<>();


}
