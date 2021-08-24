package za.ac.cput.services;

/*
    @Description:ClientService ->
    @Author: Cole Hanekom
    @Student Number: 217267556
    @Date: 04 August 2021
*/

import org.springframework.stereotype.Service;
import za.ac.cput.entity.Client;
import za.ac.cput.repository.client.ClientRepository;
import za.ac.cput.services.client.IClientService;
import java.util.Set;

@Service
public class ClientService implements IClientService {
    private static  ClientService service = null;
    private ClientRepository repository = null;

    private ClientService(){this.repository = ClientRepository.getRepository();}

    public static ClientService getService(){
        if(service == null){
            service = new ClientService();
        }
        return service;
    }
    @Override
    public Client create(Client client){return this.repository.create(client);}

    @Override
    public Client read(String clientID){return this.repository.read(clientID);}

    @Override
    public Client update(Client client){return this.repository.update(client);}

    @Override
    public boolean delete(String clientID){
        return this.repository.delete(clientID);
    }

    @Override
    public Set<Client> getAll() {
        return (Set<Client>) this.repository.getAll();
    }
}
