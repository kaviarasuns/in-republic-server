package in.republic_server.teamrepublic.controllers;


import in.republic_server.teamrepublic.dtos.PoliticalPartiesDto;
import in.republic_server.teamrepublic.models.PoliticalParties;
import in.republic_server.teamrepublic.services.PoliticalPartiesService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/v1/political-parties")
public class PoliticalPartiesController {

    private PoliticalPartiesService politicalPartiesService;

    public PoliticalPartiesController(@Qualifier("politicalPartiesServiceImpl") PoliticalPartiesService politicalPartiesService){
        this.politicalPartiesService = politicalPartiesService;
    }

    @PostMapping
    public PoliticalPartiesDto createPoliticalParty(@RequestBody PoliticalPartiesDto politicalParty){
        return politicalPartiesService.createParty(politicalParty);
    }

    @GetMapping("/all")
    public  List<PoliticalPartiesDto> getAllParties(){
        return politicalPartiesService.getAllParties();
    }

    @GetMapping("/abbreviation/{abbreviation}")
    public Optional<PoliticalPartiesDto> getPartyByAbbreviation(@PathVariable String abbreviation){
        return politicalPartiesService.findPartyByAbbreviation(abbreviation);
    }

    @PutMapping("/{id}")
    public PoliticalPartiesDto updateParty(@PathVariable UUID id, @RequestBody PoliticalPartiesDto updatedPartyDto){
            return politicalPartiesService.updateParty(id, updatedPartyDto);
    }




}
