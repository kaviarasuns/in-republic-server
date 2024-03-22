package in.republic_server.teamrepublic.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="political_parties")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PoliticalParties extends BaseModel {
    @Column
    private String party_type;

    @Column
    private String abbreviation;

    @Column
    private String party_name;
}
