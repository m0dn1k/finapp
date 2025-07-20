package project.finapp.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import project.finapp.entity.Client;

import java.util.Optional;
import java.util.UUID;

public interface ClientRepository extends JpaRepository<Client, UUID> {

    Optional<Client> findById(UUID client_id);

    Optional<Client> findByName(String name);
}
