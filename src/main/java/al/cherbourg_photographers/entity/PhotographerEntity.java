package al.cherbourg_photographers.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name="photographe")
public class PhotographerEntity {
    @Id
    @Column(name = "photographer_id", nullable = false)
    private int id;

    @Column(name = "date_debut", length = 20)
    private String startDate;

    @Column(name = "date_fin", length = 20)
    private String endDate;
}
