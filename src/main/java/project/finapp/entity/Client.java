package project.finapp.entity;
import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "clients")
public class Client {

//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client_seq")
//    @SequenceGenerator(name = "client_seq", sequenceName = "client_sequence", allocationSize = 1)
//    private Long client_id;
    @Id
    @GeneratedValue
    @Column(name = "client_id", columnDefinition = "UUID")
    private UUID client_id;

    private String name;

    public Client() {
    }

    public Client(UUID client_id, String name) {
        this.client_id = client_id;
        this.name = name;
    }

    public UUID getClient_id() {
        return client_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
