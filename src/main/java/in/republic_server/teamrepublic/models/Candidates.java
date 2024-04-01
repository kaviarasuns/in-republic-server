package in.republic_server.teamrepublic.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "candidates")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Candidates extends BaseModel {
    @Column
    private String candidate_name;

    @Column
    private String sex;

    @Column
    private String age;

    @OneToMany(mappedBy = "candidates")
    private List<StateElectionResults> state_election_results;
}
