package al.cherbourg_photographers.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {
    private int id;

    // 0 pour homme, 1 pour femme
    @NotNull
    private boolean gender;

    @Size(max = 50, message = "Le patronyme ne doit pas dépasser 50 caractères.")
    private String lastname;

    @Size(max = 50, message = "Le prénom ne doit pas dépasser 50 caractères.")
    private String firstname;

    private LocalDate birthdate;

    private LocalDate deathdate;

    @Size(max = 50, message = "Le lieu de naissance ne doit pas dépasser 50 caractères.")
    private String birthPlace;

    @Size(max = 50, message = "Le lieu de décès ne doit pas dépasser 50 caractères.")
    private String deathPlace;

    @Size(max = 50, message = "L'activité professionnelle ne doit pas dépasser 50 caractères.")
    private String job;
}
