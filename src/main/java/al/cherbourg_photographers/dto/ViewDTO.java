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
public class ViewDTO {
    private int id;

    @NotEmpty
    @Size(max = 100, message = "Le nom du monument ne doit pas dépasser 100 caractères")
    private String monumentName;

    private List<PhotographDTO> photographs;
}
