package project.finapp.service;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.finapp.entity.Client;
import project.finapp.repository.ClientRepository;
import java.util.List;
import java.util.UUID;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client createNewClient(Client client) {
        if (client.getClient_id() != null) {
            throw new IllegalArgumentException("ID must be empty (null)");
        }
        return clientRepository.save(client);
    }

    public void deleteClientById(UUID clientId) {
        if (clientRepository.findById(clientId).isEmpty()) {
            throw new IllegalArgumentException("Client not found by ID = %s".formatted(clientId));
        }
        clientRepository.deleteById(clientId);
    }

    @Transactional
    public void updateClient(UUID clientId, String name) {
        var client = clientRepository.findById(clientId)
                .orElseThrow( () -> new IllegalArgumentException("Client not found by ID = %s"
                        .formatted(clientId))
                );
        if (name != null && !name.isEmpty() && !name.equals(client.getName())) {
            client.setName(name);
//            clientRepository.save(client);
        }
    }
}
