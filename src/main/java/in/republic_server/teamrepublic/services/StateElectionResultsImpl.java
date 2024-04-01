package in.republic_server.teamrepublic.services;

import in.republic_server.teamrepublic.dtos.StateElectionResultsDto;
import in.republic_server.teamrepublic.models.Candidates;
import in.republic_server.teamrepublic.models.PoliticalParties;
import in.republic_server.teamrepublic.models.StateElectionResults;
import in.republic_server.teamrepublic.repositories.CandidatesRepository;
import in.republic_server.teamrepublic.repositories.PoliticalPartiesRepository;
import in.republic_server.teamrepublic.repositories.StateElectionResultsRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service("stateElectionResultsImpl")
public class StateElectionResultsImpl implements StateElectionResultsService {
    private final StateElectionResultsRepository stateElectionResultsRepository;
    private final CandidatesRepository candidatesRepository;
    private final PoliticalPartiesRepository politicalPartiesRepository;

    public StateElectionResultsImpl(StateElectionResultsRepository stateElectionResultsRepository,
                                    CandidatesRepository candidatesRepository,
                                    PoliticalPartiesRepository politicalPartiesRepository){
        this.stateElectionResultsRepository = stateElectionResultsRepository;
        this.candidatesRepository = candidatesRepository;
        this.politicalPartiesRepository = politicalPartiesRepository;
    }

    @Override
    public void saveElectionResults(List<StateElectionResultsDto> elctionResultsList){
        List<StateElectionResults> entities = elctionResultsList.stream().map(this::mapToEntity).collect(Collectors.toList());
        stateElectionResultsRepository.saveAll(entities);
    }

    private StateElectionResults mapToEntity(StateElectionResultsDto stateElectionResultsDto){
        StateElectionResults electionResults = new StateElectionResults();

        electionResults.setId(stateElectionResultsDto.getId());
        electionResults.setLegislative_assembly(stateElectionResultsDto.getLegislative_assembly());
        electionResults.setConstituency(stateElectionResultsDto.getConstituency());
        electionResults.setYear(stateElectionResultsDto.getYear());

//        UUID candidatesId = UUID.fromString(stateElectionResultsDto.getCandidates());
//        Candidates candidate = candidatesRepository.findById(UUID.fromString(stateElectionResultsDto.getCandidates()))
//                .orElseThrow(() -> new EntityNotFoundException("Candidate not found with ID: " + candidatesId));
//        electionResults.setCandidates(candidate);

        Candidates candidate = candidatesRepository.findById(stateElectionResultsDto.getCandidates());
        electionResults.setCandidates(candidate);

        electionResults.setCategory(stateElectionResultsDto.getCategory());

        PoliticalParties party = politicalPartiesRepository.findById(stateElectionResultsDto.getPolitical_parties());
        electionResults.setPolitical_parties(party);

        electionResults.setSymbol(stateElectionResultsDto.getSymbol());
        electionResults.setGeneral_votes(stateElectionResultsDto.getGeneral_votes());
        electionResults.setPostal_votes(stateElectionResultsDto.getPostal_votes());
        electionResults.setTotal_votes(stateElectionResultsDto.getTotal_votes());
        electionResults.setVotes_polled_percent(stateElectionResultsDto.getVotes_polled_percent());

        return electionResults;
    }



}
