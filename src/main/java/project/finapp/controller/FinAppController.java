package project.finapp.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.finapp.entity.Client;
import project.finapp.service.ClientService;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class FinAppController {

    private final ClientService clientService;

    @Autowired
    public FinAppController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/get_all_clients")
    public List<Client> clientsList() {
        return clientService.getAllClients();
    }

    @PostMapping("/create_new_client")
    public Client createNewClient(
            @RequestBody Client client
    ) {
        return clientService.createNewClient(client);
    }

    @PutMapping("/change_client_name/{id}")
    public void changeClientName(
            @PathVariable("id") UUID client_id,
            @RequestParam(value = "name", required = false) String name
    ) {
        clientService.updateClient(client_id, name);
    }

    @DeleteMapping("/delete_client_by_id/{id}")
    public void deleteClientById(@PathVariable("id") UUID client_id) {
        clientService.deleteClientById(client_id);
    }


}
