package in.republic_server.teamrepublic.controllers;

import in.republic_server.teamrepublic.dtos.CandidatesDto;
import in.republic_server.teamrepublic.services.CandidatesService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/candidates")
public class CandidatesController {
    private CandidatesService candidatesService;

    public CandidatesController(@Qualifier("candidatesServiceImpl") CandidatesService candidatesService){
        this.candidatesService = candidatesService;
    }

    @PostMapping
    public void saveCandidates(@RequestBody List<CandidatesDto> candidatesList){
         candidatesService.saveCandidates(candidatesList);
    }

    @GetMapping("/all")
    public List<CandidatesDto> getAllCandidates(){
        return candidatesService.getAllCandidates();
    }

}
