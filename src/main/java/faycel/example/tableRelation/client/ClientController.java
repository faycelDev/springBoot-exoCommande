package faycel.example.tableRelation.client;

import faycel.example.tableRelation.commande.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

public class ClientController {

    @Autowired
    private ClientRepository clientRepository;


    @GetMapping(value = "/client")
    public List<Client> getFindAll(){

        return clientRepository.findAll();
    }

    @GetMapping(value = "/client/{id}")
    public Optional<Client> getFindById(@PathVariable ("id") Long id){

        return clientRepository.findById(id);
    }

    @PostMapping(value = "/client")
    public void create(@RequestBody Client client){

        clientRepository.save(client);
    }

    @PutMapping(value = "/client{id}")
    public void update(@PathVariable ("id") Long id, @RequestBody Client client){

        var client2 = clientRepository.findById(id);
        if(client2.isPresent()){
            client.setId(id);
            clientRepository.save(client);
        }
    }

    @DeleteMapping(value = "/client{id}")
    public void deleteById(@PathVariable ("id") Long id){

        clientRepository.deleteById(id);
    }


}
