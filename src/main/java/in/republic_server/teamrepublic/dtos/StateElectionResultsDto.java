package in.republic_server.teamrepublic.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StateElectionResultsDto {
    private String id;
    private String legislative_assembly;
    private String constituency;
    private String year;
    private String candidates;
    private String category;
    private String political_parties;
    private String symbol;
    private String general_votes;
    private String postal_votes;
    private String total_votes;
    private String votes_polled_percent;
}
