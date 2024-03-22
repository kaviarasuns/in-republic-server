package in.republic_server.teamrepublic.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PoliticalPartiesDto {
    private Long id;
    private String party_type;
    private String abbreviation;
    private String party_name;
}
