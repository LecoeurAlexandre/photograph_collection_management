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
@Table(name = "photographe_adresse")
public class PhotographerAddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "photographe_adresse_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "photographe_id")
    private PhotographerEntity photographer;

    @ManyToOne
    @JoinColumn(name = "adresse_id")
    private AddressEntity address;

    @Column(name = "adresse_debut", length = 20)
    private String addressStartDate;

    @Column(name = "adresse_fin", length = 20)
    private String addressEndDate;
}
