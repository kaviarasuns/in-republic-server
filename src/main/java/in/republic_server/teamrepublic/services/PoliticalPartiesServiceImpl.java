package in.republic_server.teamrepublic.services;

import in.republic_server.teamrepublic.dtos.PoliticalPartiesDto;
import in.republic_server.teamrepublic.models.PoliticalParties;
import in.republic_server.teamrepublic.repositories.PoliticalPartiesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

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

    @Override
    public List<PoliticalPartiesDto> getAllParties(){
        List<PoliticalParties> parties = politicalPartiesRepository.findAll();
        return parties.stream()
                .map(party -> {
                    PoliticalPartiesDto partyDto = new PoliticalPartiesDto();
                    partyDto.setParty_type(party.getParty_type());
                    partyDto.setAbbreviation(party.getAbbreviation());
                    partyDto.setParty_name(party.getParty_name());
                    return partyDto;
                })
                .collect(Collectors.toList());
    }

    @Override
    public Optional<PoliticalPartiesDto> findPartyByAbbreviation(String abbreviation) {
        Optional<PoliticalParties> optionalParty = politicalPartiesRepository.findPartyByAbbreviation(abbreviation);
        if (optionalParty.isPresent()) {
            PoliticalParties party = optionalParty.get();
            PoliticalPartiesDto partyDto = new PoliticalPartiesDto();
            partyDto.setParty_type(party.getParty_type());
            partyDto.setAbbreviation(party.getAbbreviation());
            partyDto.setParty_name(party.getParty_name());
            return Optional.of(partyDto);
        } else {
            return Optional.empty();
        }
    }

    public PoliticalPartiesDto updateParty(UUID id, PoliticalPartiesDto updatedPartyDto) {
        Optional<PoliticalParties> optionalParty = politicalPartiesRepository.findById(id);
        if (optionalParty.isPresent()) {
            PoliticalParties party = optionalParty.get();
            // Update the party with the new information
            party.setParty_type(updatedPartyDto.getParty_type());
            party.setAbbreviation(updatedPartyDto.getAbbreviation());
            party.setParty_name(updatedPartyDto.getParty_name());
            PoliticalParties savedParty = politicalPartiesRepository.save(party);
            // Map the updated party to DTO and return
            PoliticalPartiesDto updatedPartyResponseDto = new PoliticalPartiesDto();
            updatedPartyResponseDto.setParty_type(savedParty.getParty_type());
            updatedPartyResponseDto.setAbbreviation(savedParty.getAbbreviation());
            updatedPartyResponseDto.setParty_name(savedParty.getParty_name());
            return updatedPartyResponseDto;
        } else {
            // Handle case when party with given id is not found
            // You can throw an exception, or return an error message
            return null;
        }
    }
}
