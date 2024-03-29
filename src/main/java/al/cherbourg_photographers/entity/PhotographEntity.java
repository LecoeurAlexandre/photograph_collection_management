package al.cherbourg_photographers.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name="photographie")
public class PhotographEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "photographie_id")
    private int id;

    @Column(name = "cote", nullable = false, length = 10, unique = true)
    private String fileNumber;

    @Column(name = "lib_photo_description", nullable = false, length = 255)
    private String photoDescription;

    @Column(name = "url_recto", nullable = false, length = 100)
    private String urlRecto;

    @Column(name = "url_verso", nullable = false, length = 100)
    private String urlVerso;

    @Column(name = "bool_orientation", nullable = false)
    private boolean orientation;

    @Column(name = "datation", nullable = false, length = 9)
    private String datation;

    @Column(name = "date_acquisition")
    private LocalDate date;

    @Column(name = "lieu_achat", length = 24)
    private String placeOfPurchase;

    @Column(name = "prix")
    private float price;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fond_id")
    private WorkshopBackgroundEntity background;
}
