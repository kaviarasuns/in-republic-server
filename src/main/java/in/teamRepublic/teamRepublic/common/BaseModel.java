package in.teamRepublic.teamRepublic.common;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

@Getter
@Setter
@MappedSuperclass
public class BaseModel {
    @Id
    @UuidGenerator
    private String id;
}
