package in.republic_server.teamrepublic.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="political_parties")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PoliticalParties extends BaseModel {
    @Column
    private String party_type;

    @Column(unique = true)
    private String abbreviation;

    @Column(unique = true)
    private String party_name;

    @OneToMany(mappedBy = "political_parties")
    private List<StateElectionResults> state_election_results;
}
