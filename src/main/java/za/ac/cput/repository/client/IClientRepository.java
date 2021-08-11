package za.ac.cput.repository.client;

/*
    @Description:IClientRepository ->
    @Author: Cole Hanekom
    @Student Number: 217267556
    @Date: 04 August 2021
*/

import za.ac.cput.entity.Client;
import za.ac.cput.repository.IRepository;
import java.util.Set;

public interface IClientRepository extends IRepository<Client, String> {
    Set<Client> getAll();
}
