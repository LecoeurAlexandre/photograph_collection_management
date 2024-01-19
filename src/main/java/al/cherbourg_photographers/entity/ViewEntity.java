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
@Table(name="vue")
public class ViewEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vue_id")
    private int id;

    @Column(name = "lib_monument", length = 100, nullable = false)
    private String monumentName;

    @ManyToMany
    @JoinTable(
            name = "vue_photographie",
            joinColumns = @JoinColumn(name = "vue_id"),
            inverseJoinColumns = @JoinColumn(name = "photographie_id"))
    private List<PhotographEntity> photographs = new ArrayList<>();
}
