package al.cherbourg_photographers.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name="photographe")
@PrimaryKeyJoinColumn(name = "photographer_id")
public class PhotographerEntity extends PersonEntity {

    @Column(name = "date_debut", length = 20)
    private String startDate;

    @Column(name = "date_fin", length = 20)
    private String endDate;

}
