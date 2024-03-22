package in.republic_server.teamrepublic.services;

import in.republic_server.teamrepublic.dtos.PoliticalPartiesDto;
import in.republic_server.teamrepublic.models.PoliticalParties;
import in.republic_server.teamrepublic.repositories.PoliticalPartiesRepository;
import org.springframework.stereotype.Service;

@Service("politicalPartiesServiceImpl")
public class PoliticalPartiesServiceImpl implements PoliticalPartiesService {
    private final PoliticalPartiesRepository politicalPartiesRepository;

    public PoliticalPartiesServiceImpl(PoliticalPartiesRepository politicalPartiesRepository){
        this.politicalPartiesRepository = politicalPartiesRepository;
    }

    @Override
    public PoliticalPartiesDto createParty(PoliticalPartiesDto politicalPartiesDto){
        PoliticalParties politicalParty = new PoliticalParties();
        politicalParty.setParty_type(politicalPartiesDto.getParty_type());
        politicalParty.setAbbreviation(politicalPartiesDto.getAbbreviation());
        politicalParty.setParty_name(politicalPartiesDto.getParty_name());

        PoliticalParties savedParty = politicalPartiesRepository.save(politicalParty);

        PoliticalPartiesDto createdPartyDto = new PoliticalPartiesDto();
        createdPartyDto.setId(createdPartyDto.getId());
        createdPartyDto.setParty_type(savedParty.getParty_type());
        createdPartyDto.setAbbreviation(savedParty.getAbbreviation());
        createdPartyDto.setParty_name(savedParty.getParty_name());

        return createdPartyDto;
    }
}
