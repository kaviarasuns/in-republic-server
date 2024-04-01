package in.republic_server.teamrepublic.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="state_election_results")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StateElectionResults extends BaseModel{
    @Column
    private String legislative_assembly;

    @Column
    private String constituency;

    @Column
    private String year;

    @ManyToOne
    @JoinColumn(name="candidates")
    private Candidates candidates;

    @Column
    private String category;

    @ManyToOne()
    @JoinColumn(name = "political_parties")
    private PoliticalParties political_parties;

    @Column
    private String symbol;

    @Column
    private String general_votes;

    @Column
    private String postal_votes;

    @Column
    private String total_votes;

    @Column
    private String votes_polled_percent;
}
