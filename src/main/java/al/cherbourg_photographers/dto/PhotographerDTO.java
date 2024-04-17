package al.cherbourg_photographers.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@NoArgsConstructor
@Getter
@Setter
public class PhotographerDTO extends PersonDTO {

    public PhotographerDTO(int id, @NotNull boolean gender, @Size(max = 50, message = "Le patronyme ne doit pas dépasser 50 caractères.") String lastname, @Size(max = 50, message = "Le nom de jeune fille ne doit pas dépasser 50 caractères.") String maidenName, @Size(max = 50, message = "Le prénom ne doit pas dépasser 50 caractères.") String firstname, LocalDate birthdate, LocalDate deathdate, @Size(max = 50, message = "Le lieu de naissance ne doit pas dépasser 50 caractères.") String birthPlace, @Size(max = 50, message = "Le lieu de décès ne doit pas dépasser 50 caractères.") String deathPlace, @Size(max = 50, message = "L'activité professionnelle ne doit pas dépasser 50 caractères.") String job, String startDate, String endDate) {
        super(id, gender, lastname, maidenName, firstname, birthdate, deathdate, birthPlace, deathPlace, job);
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Size(max=20, message = "La date de début ne doit pas contenir plus de 20 caractères")
    private String startDate;

    @Size(max=20, message = "La date de fin ne doit pas contenir plus de 20 caractères")
    private String endDate;
}
