package za.ac.cput.controller;

/*
   @Subject: Project 3
   @Description:ClientAccountController.java
   @Author: Elrich Herman
   @Student Number: 218150040
   @Date: 19 June 2021
*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.ClientAccount;
import za.ac.cput.factory.ClientAccountFactory;
import za.ac.cput.services.ClientAccountService;
import java.util.Set;

@RestController
@RequestMapping("/clientAccount")
public class ClientAccountController {

    @Autowired
    private ClientAccountService clientAccountService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ClientAccount create(@RequestBody ClientAccount clientAccount){
        ClientAccount newClientAccount = ClientAccountFactory.createClientAccount(clientAccount.getNumberBorrowed(), clientAccount.getAccountNumber());
        return clientAccountService.create(newClientAccount);
    }

    @RequestMapping(value = "/read/{accountNumber}", method = RequestMethod.GET)
    public ClientAccount read(@PathVariable String accountNumber)
    {
        return clientAccountService.read(accountNumber);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ClientAccount update(@RequestBody ClientAccount clientAccount){
        ClientAccount newClientAccount = new ClientAccount.Builder().copy(clientAccount)
                .NumberBorrowed(clientAccount.getNumberBorrowed()).build();
        return clientAccountService.update(newClientAccount);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public boolean delete(@RequestBody ClientAccount clientAccount){
        if(clientAccountService.delete(clientAccount.getAccountNumber()))
            return true;
        else {
            return false;
        }
    }

    @RequestMapping(value = "/getall", method = RequestMethod.GET)
    public Set<ClientAccount> getAll(){
        return clientAccountService.getAll();
    }
}
