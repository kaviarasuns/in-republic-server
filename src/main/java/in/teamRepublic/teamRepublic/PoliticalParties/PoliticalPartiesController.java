package in.teamRepublic.teamRepublic.PoliticalParties;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/political-parties")
public class PoliticalPartiesController {

    @GetMapping("/all")
    public String getAllParties(){
        return "Hello";
    }
}
