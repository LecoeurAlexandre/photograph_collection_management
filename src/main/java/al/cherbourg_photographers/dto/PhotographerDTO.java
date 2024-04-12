package al.cherbourg_photographers.dto;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PhotographerDTO extends PersonDTO {

    @Size(max=20, message = "La date de début ne doit pas contenir plus de 20 caractères")
    private String startDate;

    @Size(max=20, message = "La date de fin ne doit pas contenir plus de 20 caractères")
    private String endDate;
}
