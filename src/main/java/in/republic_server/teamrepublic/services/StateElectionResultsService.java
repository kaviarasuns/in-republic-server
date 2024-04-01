package in.republic_server.teamrepublic.services;

import in.republic_server.teamrepublic.dtos.StateElectionResultsDto;

import java.util.List;

public interface StateElectionResultsService {
    void saveElectionResults(List<StateElectionResultsDto> elctionResultsList);
}
