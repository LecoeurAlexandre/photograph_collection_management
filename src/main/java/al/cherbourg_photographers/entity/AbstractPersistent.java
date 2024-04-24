package al.cherbourg_photographers.entity;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@MappedSuperclass
abstract class AbstractPersistent {
    private LocalDateTime creationDate;
    private LocalDateTime updateDate;
}
