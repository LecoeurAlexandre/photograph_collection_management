package al.cherbourg_photographers.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Year;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
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

    @Column(name = "annee_adresse_debut", length = 20)
    private Year addressStartDate;

    @Column(name = "bool_exact_debut", nullable = false)
    private boolean exactStartDate;

    @Column(name = "annee_adresse_fin", length = 20)
    private Year addressEndDate;

    @Column(name = "bool_exact_fin", nullable = false)
    private boolean exactEndDate;
}
