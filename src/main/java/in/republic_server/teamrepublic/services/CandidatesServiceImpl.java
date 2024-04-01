package in.republic_server.teamrepublic.services;

import in.republic_server.teamrepublic.dtos.CandidatesDto;
import in.republic_server.teamrepublic.dtos.PoliticalPartiesDto;
import in.republic_server.teamrepublic.models.Candidates;
import in.republic_server.teamrepublic.models.PoliticalParties;
import in.republic_server.teamrepublic.repositories.CandidatesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("candidatesServiceImpl")
public class CandidatesServiceImpl implements CandidatesService{
    private final CandidatesRepository candidatesRepository;

    public CandidatesServiceImpl(CandidatesRepository candidatesRepository){
        this.candidatesRepository = candidatesRepository;
    }

    @Override
    public void saveCandidates(List<CandidatesDto> candidatesList){
        List<Candidates> entities = candidatesList.stream().map(this::mapToEntity).collect(Collectors.toList());
        candidatesRepository.saveAll(entities);
    }

    private Candidates mapToEntity(CandidatesDto candidatesDto) {
        Candidates candidates = new Candidates();
        candidates.setCandidate_name(candidatesDto.getCandidate_name());
        candidates.setSex(candidatesDto.getSex());
        candidates.setAge(candidatesDto.getAge());

        return candidates;
    }


    @Override
    public List<CandidatesDto> getAllCandidates(){
        List<Candidates> candidates = candidatesRepository.findAll();
        return candidates.stream()
                .map(candidate -> {
                    CandidatesDto candidatesDto = new CandidatesDto();
                    candidatesDto.setId(candidate.getId());
                    candidatesDto.setCandidate_name(candidate.getCandidate_name());
                    candidatesDto.setAge(candidate.getAge());
                    candidatesDto.setSex(candidate.getSex());
                    return candidatesDto;
                })
                .collect(Collectors.toList());
    }
}
