/*package za.ac.cput.repository.client;





import za.ac.cput.entity.Client;
import java.util.HashSet;
import java.util.Set;

public class ClientRepositoryUnused implements IClientRepository{
    private static ClientRepositoryUnused repository = null;
    private Set<Client> clientDB = null;

    private ClientRepositoryUnused(){clientDB = new HashSet<Client>();
    }

    public static ClientRepositoryUnused getRepository(){
        if(repository == null){
            repository = new ClientRepositoryUnused();
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
*/

