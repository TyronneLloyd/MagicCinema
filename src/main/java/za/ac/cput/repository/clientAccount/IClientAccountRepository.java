package za.ac.cput.repository.clientAccount;

/*
   @Subject: Project 3
   @Description:ILoginRepository.java
   @Author: Elrich Herman
   @Student Number: 218150040
   @Date: 07 August 2021
*/

import za.ac.cput.entity.ClientAccount;
import za.ac.cput.repository.IRepository;
import java.util.*;

public interface IClientAccountRepository extends IRepository<ClientAccount, String>
{
    List<ClientAccount> getAll();
}