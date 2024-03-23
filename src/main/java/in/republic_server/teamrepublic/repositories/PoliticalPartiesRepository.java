package in.republic_server.teamrepublic.repositories;

import in.republic_server.teamrepublic.models.PoliticalParties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PoliticalPartiesRepository extends JpaRepository<PoliticalParties, UUID> {
    Optional<PoliticalParties> findPartyByAbbreviation(String abbreviation);
}
