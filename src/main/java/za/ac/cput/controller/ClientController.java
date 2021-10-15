package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.Client;
import za.ac.cput.factory.ClientFactory;
import za.ac.cput.services.ClientService;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService service;

    @PostMapping(value = "/create")
    public Client create(@RequestBody Client client){
        Client newClient = ClientFactory.createClient(
                client.getName(),
                client.getSurname(),
                client.getContactNumber()
        );
        return service.create(newClient);
    }

    @GetMapping(value = "/read/{clientID}")
    public Client read(@PathVariable String clientID){
        return service.read(clientID);
    }


    @PutMapping(value = "/update")
    public Client update(@RequestBody Client client){
        return service.update(client);
    }

    @DeleteMapping("/delete/{clientID}")
    public boolean delete(@PathVariable String clientID) {
        return service.delete(clientID);
    }

    @GetMapping(value = "/getall")
    public List<Client> getAll(){
        return service.getAll();
    }
}
