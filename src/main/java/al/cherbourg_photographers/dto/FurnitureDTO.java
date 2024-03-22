package al.cherbourg_photographers.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FurnitureDTO {
    private int id;

    @NotEmpty(message = "Le nom de mobilier ne doit pas être vide.")
    @Size(max = 50, message = "Le nom de mobilier ne doit pas contenir plus de 50 caractères.")
    private String furnitureName;

    @NotEmpty(message = "La description du mobilier ne doit pas être vide.")
    @Size(max = 255, message = "La description du mobilier ne doit pas contenir plus de 255 caractères.")
    private String furnitureDescription;
}
