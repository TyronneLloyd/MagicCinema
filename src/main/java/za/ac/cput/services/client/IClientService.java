package za.ac.cput.services.client;


import org.springframework.stereotype.Repository;
import za.ac.cput.entity.Client;
import za.ac.cput.services.IService;

import java.util.List;
import java.util.Set;

public interface IClientService extends IService<Client, String> {
    List<Client> getAll();
}
