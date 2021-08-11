package za.ac.cput.repository.login;

/*
   @Subject: Project 3
   @Description:ILoginRepository.java
   @Author: Elrich Herman
   @Student Number: 218150040
   @Date: 07 August 2021
*/

import za.ac.cput.repository.IRepository;
import za.ac.cput.entity.Login;
import java.util.List;

public interface ILoginRepository extends IRepository<Login, String>
{
    List<Login> getAll();
}
