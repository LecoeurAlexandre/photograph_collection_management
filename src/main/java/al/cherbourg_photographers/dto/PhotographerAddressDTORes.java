package al.cherbourg_photographers.dto;

import al.cherbourg_photographers.entity.AddressEntity;
import al.cherbourg_photographers.entity.PhotographerEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PhotographerAddressDTORes {

    private int id;

    private PhotographerEntity photographer;

    private AddressEntity address;

    private String addressStartDate;

    private String addressEndDate;
}
