package za.ac.cput.services.client;

/*
    @Description:IClientService ->
    @Author: Cole Hanekom
    @Student Number: 217267556
    @Date: 04 August 2021
*/

import za.ac.cput.entity.Client;
import za.ac.cput.services.IService;
import java.util.Set;

public interface IClientService extends IService<Client, String> {
    Set<Client> getAll();
}
