package faycel.example.tableRelation.commande;

import faycel.example.tableRelation.client.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CommandeController {

    @Autowired
    private CommandeRepository commandeRepository;
    @Autowired
    private ClientRepository clientRepository;

    @GetMapping(value = "/commande")
    public List<Commande> getFindAll(){

      return commandeRepository.findAll();

    }
    @GetMapping(value = "/commande/{id}")
    public Optional <Commande> getFinById(@PathVariable ("id") Long id){

       return commandeRepository.findById(id);
    }

    @PostMapping(value = "/commande/{id}")
    public void create(@PathVariable ("id") Long id, @RequestBody Commande commande){

        var client = clientRepository.findById(id);
        if(client.isPresent()){
            commande.setClient(client.get());
            commandeRepository.save(commande);
        }
    }

    @PutMapping(value = "/commande/{id}")
    public void updateById(@PathVariable ("id") Long id, @RequestBody Commande commande){

        var command = commandeRepository.findById(id);
        if(command.isPresent()){
            commande.setId(id);
            commandeRepository.save(commande);
        }
    }

    @DeleteMapping(value = "/commande{id}")
    public void deleteById(@PathVariable ("id") Long id){

        commandeRepository.deleteById(id);
    }
}
