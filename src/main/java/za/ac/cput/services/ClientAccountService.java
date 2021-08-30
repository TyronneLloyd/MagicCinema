package za.ac.cput.services;

/*
   @Subject: Project 3
   @Description:ClientAccountService.java
   @Author: Elrich Herman
   @Student Number: 218150040
   @Date: 07 August 2021
*/

import org.springframework.stereotype.Service;
import za.ac.cput.entity.ClientAccount;
import za.ac.cput.repository.clientAccount.ClientAccountRepository;
import za.ac.cput.services.clientAccount.IClientAccountService;
import java.util.Set;
@Service
public class ClientAccountService implements IClientAccountService
{
    private static  ClientAccountService service = null;
    private ClientAccountRepository repository = null;

    private ClientAccountService()
    {
        this.repository = ClientAccountRepository.getRepository();
    }

    public static ClientAccountService getService()
    {
        if(service == null){
            service = new ClientAccountService();
        }
        return service;
    }

    @Override
    public ClientAccount create(ClientAccount clientAccount)
    {
        return this.repository.create(clientAccount);
    }

    @Override
    public ClientAccount read(String clientID)
    {
        return this.repository.read(clientID);
    }

    @Override
    public ClientAccount update(ClientAccount clientAccount)
    {
        return  this.repository.update(clientAccount);
    }

    @Override
    public boolean delete(String equipmentStorageId)
    {
        return this.repository.delete(equipmentStorageId);
    }

    @Override
    public Set<ClientAccount> getAll()
    {
        return (Set<ClientAccount>) this.repository.getAll();
    }

}
