package in.republic_server.teamrepublic.repositories;

import in.republic_server.teamrepublic.models.PoliticalParties;
import in.republic_server.teamrepublic.models.StateElectionResults;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StateElectionResultsRepository extends JpaRepository<StateElectionResults, UUID> {
}
