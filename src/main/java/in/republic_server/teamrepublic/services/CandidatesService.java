package in.republic_server.teamrepublic.services;

import in.republic_server.teamrepublic.dtos.CandidatesDto;

import java.util.List;

public interface CandidatesService {
    void saveCandidates(List<CandidatesDto> candidatesList);

    List<CandidatesDto> getAllCandidates();
}
