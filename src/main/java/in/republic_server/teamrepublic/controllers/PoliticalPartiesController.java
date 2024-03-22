package in.republic_server.teamrepublic.controllers;


import in.republic_server.teamrepublic.dtos.PoliticalPartiesDto;
import in.republic_server.teamrepublic.models.PoliticalParties;
import in.republic_server.teamrepublic.services.PoliticalPartiesService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
