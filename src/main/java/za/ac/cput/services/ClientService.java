package za.ac.cput.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.Client;
import za.ac.cput.repository.client.ClientRepository;
import za.ac.cput.services.client.IClientService;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class ClientService implements IClientService {
    private ClientRepository repository;

    @Autowired
    private ClientService(ClientRepository repository) {
        this.repository = repository;
    }

    @Override
    public Client create(Client client){return this.repository.save(client);}

    @Override
    public Client read(String clientID){
        return this.repository.findById(clientID).orElseThrow(() -> new EntityNotFoundException("Client with id " + clientID + " was not found" ));
    }

    @Override
    public Client update(Client client){
        if(this.repository.existsById(client.getClientID()))
            return this.repository.save(client);
        return null;
    }

    @Override
    public boolean delete(String clientID){
        this.repository.deleteById(clientID);
        if(this.repository.existsById(clientID))
            return false;
        else
            return true;
    }

    @Override
    public List<Client> getAll() {
        return this.repository.findAll(Sort.by(Sort.Direction.ASC, "name"));
    }
}
