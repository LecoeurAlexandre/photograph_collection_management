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
@Table(name="format")
public class FormatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "format_id")
    private int id;

    @Column(name = "lib_format", length = 30, unique = true)
    private String formatName;

    @Column(name = "size_format", nullable = false, unique = true)
    private String formatSize;
}
