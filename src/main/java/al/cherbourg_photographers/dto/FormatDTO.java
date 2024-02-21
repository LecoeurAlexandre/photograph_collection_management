package al.cherbourg_photographers.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FormatDTO {
    private int id;

    @Size(max = 30, message = "Le nom de format ne doit pas contenir plus de 30 caractères.")
    private String formatName;

    @NotEmpty
    @Pattern(regexp = "^\\d{1,2}(\\.\\d+)?x\\d{1,2}(\\.\\d+)?$", message = "La taille doit correspondre au format de ces exemples : 1x2, 10.5x5...")
    private String formatSize;
}
