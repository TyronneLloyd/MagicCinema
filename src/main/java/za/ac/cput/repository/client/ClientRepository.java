package za.ac.cput.repository.client;

/*
    @Description:ClientRepository ->
    @Author: Cole Hanekom
    @Student Number: 217267556
    @Date: 04 August 2021
*/


import za.ac.cput.entity.Client;
import java.util.HashSet;
import java.util.Set;

public class ClientRepository implements IClientRepository{
    private static ClientRepository repository = null;
    private Set<Client> clientDB = null;

    private ClientRepository(){clientDB = new HashSet<Client>();
    }

    public static  ClientRepository getRepository(){
        if(repository == null){
            repository = new ClientRepository();
        }
        return  repository;
    }

    @Override
    public Client create(Client client){
        boolean success = clientDB.add(client);
        if(!success)
            return null;
        return client;
    }

    @Override
    public Client read(String clientId) {
        for (Client client : clientDB) {
            if (client.getClientID().equals(clientId)) {
                return client;
            }
        }
        return null;
    }

    @Override
    public Client update(Client client) {
        Client oldClient = read(client.getClientID());
        if(oldClient != null){
            clientDB.remove(oldClient);
            clientDB.add(client);
            return client;
        }
        return null;
    }

    @Override
    public boolean delete(String clientId){
        Client clientToDelete = read(clientId);
        if(clientToDelete == null)
            return false;
        clientDB.remove(clientToDelete);
        return true;
    }

    @Override
    public Set<Client> getAll(){
        return clientDB;
    }
}


