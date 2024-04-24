package al.cherbourg_photographers.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PhotographDTO {
    private int id;

    @NotEmpty
    @Size(max = 10, message = "La cote ne doit pas contenir plus de 10 caractères." )
    private String fileNumber;

    @NotEmpty
    @Size(max = 255, message = "La description ne doit pas dépasser 255 caractères.")
    private String photoDescription;

    @Size(max = 1000, message = "L'inscription manuscrite ne doit pas dépasser 1000 caractères.")
    private String inscription;

    @NotEmpty
    @Size(max = 100, message = "L'URL ne doit pas dépasser 100 caractères.")
    private String urlRecto;

    @NotEmpty
    @Size(max = 100, message = "L'URL ne doit pas dépasser 100 caractères.")
    private String urlVerso;

    @NotNull
    private boolean orientation;

    @NotEmpty
    @Size(min = 4, max = 9, message = "La datation doit contenir entre 4 et 9 caractères.")
    private String datation;

    @Size(min = 4, max = 9, message = "La date d'achat doit contenir entre 4 et 9 caractères.")
    private String purchaseDate;

    @Size(max = 100, message = "Le lieu d'achat ne doit pas dépasser 100 caractères.")
    private String placeOfPurchase;

    private float price;

    private WorkshopBackgroundDTO background;

    private List<ViewDTO> views;
}
