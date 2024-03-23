package in.republic_server.teamrepublic.services;

import in.republic_server.teamrepublic.dtos.PoliticalPartiesDto;
import in.republic_server.teamrepublic.models.PoliticalParties;
import in.republic_server.teamrepublic.repositories.PoliticalPartiesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface PoliticalPartiesService {
    PoliticalPartiesDto createParty(PoliticalPartiesDto party);

    List<PoliticalPartiesDto> getAllParties();

    Optional<PoliticalPartiesDto> findPartyByAbbreviation(String abbreviation);

    PoliticalPartiesDto updateParty(UUID id, PoliticalPartiesDto updatedPartyDto);
}
