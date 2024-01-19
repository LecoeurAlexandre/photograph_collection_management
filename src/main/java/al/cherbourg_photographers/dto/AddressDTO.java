package al.cherbourg_photographers.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {
    private int id;

    @Size(max = 6, message = "Le numéro de voie ne doit pas dépasser 6 caractères.")
    private String streetNumber;

    @Size(max=100, message = "Le nom de la voie ne doit pas dépasser 100 caractères.")
    private String streetName;

    @NotEmpty
    @Size(max= 20, message = "Le nom de la ville ne doit pas dépasser 100 caractères.")
    private String cityName;

    private List<WorkshopBackgroundDTO> backgrounds;
}
