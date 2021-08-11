package za.ac.cput.services.clientAccount;

/*
   @Subject: Project 3
   @Description:IClientAccountService.java
   @Author: Elrich Herman
   @Student Number: 218150040
   @Date: 07 August 2021
*/

import za.ac.cput.entity.ClientAccount;
import za.ac.cput.services.IService;
import java.util.Set;

public interface IClientAccountService extends IService<ClientAccount, String>
{
    Set<ClientAccount> getAll();
}