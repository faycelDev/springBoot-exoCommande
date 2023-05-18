package faycel.example.tableRelation.commande;

import com.fasterxml.jackson.annotation.JsonIgnore;
import faycel.example.tableRelation.client.Client;
import jakarta.persistence.*;

@Entity
public class Commande {

    String soldBy;
    int total;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "client_id")
    @JsonIgnore
    Client client;

    public Commande(){

    }


    public Commande(String soldBy, int total, Long id) {
        this.soldBy = soldBy;
        this.total = total;
        this.id = id;
    }

    public String getSoldBy() {
        return soldBy;
    }

    public void setSoldBy(String soldBy) {
        this.soldBy = soldBy;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
