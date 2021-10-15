package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.Client;
import za.ac.cput.factory.ClientFactory;
import za.ac.cput.services.ClientService;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private ClientService clientService;

    @PostMapping("/register")
    public Client create(@RequestBody Client client){
        Client newClient = ClientFactory.createClient(client.getName(),client.getSurname(), client.getContactNumber());
        return clientService.create(newClient);
    }

    @GetMapping("/read/{clientid}")
    public Client read(@PathVariable String clientid){
        return clientService.read(clientid);
    }

    @PostMapping("/update")
    public Client update(@RequestBody Client client){
        return clientService.update(client);
    }

    @PostMapping("/delete")
    public String delete(@RequestBody Client client){
        if(clientService.delete(client.getClientID()))
            return "Successfully deleted";
        else
            return "Could not delete";
    }

    //Login

    @GetMapping("/getall")
    public List<Client> getAll(){
        return clientService.getAll();
    }

}