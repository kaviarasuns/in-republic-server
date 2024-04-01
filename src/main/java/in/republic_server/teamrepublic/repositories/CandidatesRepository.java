package in.republic_server.teamrepublic.repositories;

import in.republic_server.teamrepublic.models.Candidates;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CandidatesRepository extends JpaRepository<Candidates, UUID> {
    Candidates findById(String id);
}
