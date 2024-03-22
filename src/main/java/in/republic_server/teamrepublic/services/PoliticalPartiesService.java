package in.republic_server.teamrepublic.services;

import in.republic_server.teamrepublic.dtos.PoliticalPartiesDto;
import in.republic_server.teamrepublic.models.PoliticalParties;
import in.republic_server.teamrepublic.repositories.PoliticalPartiesRepository;
import org.springframework.stereotype.Service;



public interface PoliticalPartiesService {
    PoliticalPartiesDto createParty(PoliticalPartiesDto party);
}
