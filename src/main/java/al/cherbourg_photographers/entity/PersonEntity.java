package al.cherbourg_photographers.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name="personne")
public class PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "production_id")
    private int id;

    // 0 pour homme, 1 pour femme
    @Column(name = "bool_genre", nullable = false)
    private boolean gender;

    @Column(name = "lib_patronyme", length = 50)
    private String lastname;

    @Column(name = "lib_prenom", length = 50)
    private String firstname;

    @Column(name = "date_naissance")
    private LocalDate birthdate;
    @Column(name = "date_deces")
    private LocalDate deathdate;
    @Column(name = "lieu_naissance", length = 50)
    private String birthPlace;
    @Column(name = "lieu_deces", length = 50)
    private String deathPlace;
    @Column(name = "metier", length = 50)
    private String job;
}
