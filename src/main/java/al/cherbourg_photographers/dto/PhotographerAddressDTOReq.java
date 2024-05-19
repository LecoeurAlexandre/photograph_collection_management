package al.cherbourg_photographers.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Year;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PhotographerAddressDTOReq {
    @NotNull
    private int photographerId;

    @NotNull
    private int addressId;

    private Year addressStartDate;

    private boolean exactStartDate;

    private Year addressEndDate;

    private boolean exactEndStart;
}
