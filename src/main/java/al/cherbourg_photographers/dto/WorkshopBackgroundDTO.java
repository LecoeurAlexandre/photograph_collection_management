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
public class WorkshopBackgroundDTO {
    private int id;

    @NotEmpty(message = "La description du fond ne doit pas être vide.")
    @Size(min = 10, max = 255, message = "La description du fond doit contenir entre 10 et 255 caractères.")
    private String backgroundDescription;

    private List<AddressDTO> address;
}
