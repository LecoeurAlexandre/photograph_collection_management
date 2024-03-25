package al.cherbourg_photographers.dto;

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
public class ProductDTO {
    private int id;

    @NotEmpty(message = "L'intitulé du produit ne doit pas être vide.")
    @Size(max= 100, message = "L'intitulé du produit ne doit pas contenir plus de 50 caractères.")
    private String productName;
}
