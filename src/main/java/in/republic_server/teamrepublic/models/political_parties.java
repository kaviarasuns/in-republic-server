package in.republic_server.teamrepublic.models;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class political_parties extends BaseModel {
    private String party_type;
    private String abbreviation;
    private String party_name;
}
