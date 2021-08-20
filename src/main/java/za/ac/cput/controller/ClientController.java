package za.ac.cput.controller;

/*
    @Description:ClientController ->
    @Author: Cole Hanekom
    @Student Number: 217267556
    @Date: 17 August 2021
*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.Client;
import za.ac.cput.factory.ClientFactory;
import za.ac.cput.services.ClientService;

import java.util.Set;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @PostMapping("/create")
    public Client create(@RequestBody Client client){
        Client newClient = ClientFactory.createClient(client.getName(),client.getSurname(), client.getContactNumber(), client.getAccountNumber());
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

    @GetMapping("/getall")
    public Set<Client> getAll(){
        return clientService.getAll();
    }

}