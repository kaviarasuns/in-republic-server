package in.republic_server.teamrepublic.controllers;

import in.republic_server.teamrepublic.dtos.PoliticalPartiesDto;
import in.republic_server.teamrepublic.dtos.StateElectionResultsDto;
import in.republic_server.teamrepublic.services.StateElectionResultsService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/state-election-results")
public class StateElectionResultsController {
    private StateElectionResultsService stateElectionResultsService;

    public StateElectionResultsController(@Qualifier("stateElectionResultsImpl") StateElectionResultsService stateElectionResultsService){
        this.stateElectionResultsService = stateElectionResultsService;
    }

    @PostMapping
    public void saveElectionResults(@RequestBody List<StateElectionResultsDto> electionResultsList){
        stateElectionResultsService.saveElectionResults(electionResultsList);
    }
}
