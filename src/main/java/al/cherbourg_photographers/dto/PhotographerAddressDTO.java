package al.cherbourg_photographers.dto;

import al.cherbourg_photographers.entity.AddressEntity;
import al.cherbourg_photographers.entity.PhotographEntity;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PhotographerAddressDTO {
    private int id;
    private PhotographEntity photographer;
    private AddressEntity address;
    @Size(max=20, message = "La date de début d'exercice à l'adresse ne doit pas contenir plus de 20 caractères")
    private String addressStartDate;
    @Size(max=20, message = "La date de fin d'exercice à l'adresse ne doit pas contenir plus de 20 caractères")
    private String addressEndDate;
}
