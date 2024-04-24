package al.cherbourg_photographers.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name="photographie")
public class PhotographEntity extends AbstractPersistent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "photographie_id")
    private int id;

    @Column(name = "cote", nullable = false, length = 10, unique = true)
    private String fileNumber;

    @Column(name = "lib_photo_description", nullable = false, length = 255)
    private String photoDescription;

    @Column(name = "lib_inscription", length = 1000)
    private String inscription;

    @Column(name = "url_recto", nullable = false, length = 100)
    private String urlRecto;

    @Column(name = "url_verso", nullable = false, length = 100)
    private String urlVerso;

    @Column(name = "bool_orientation", nullable = false)
    private boolean orientation;

    @Column(name = "datation", nullable = false, length = 9)
    private String datation;

    @Column(name = "date_acquisition")
    private String purchaseDate;

    @Column(name = "lieu_achat", length = 100)
    private String placeOfPurchase;

    @Column(name = "prix")
    private float price;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fond_id")
    private WorkshopBackgroundEntity background;

    @ManyToMany(mappedBy = "photographs")
    private List<ViewEntity> views = new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "format_id")
    private FormatEntity format;
}
