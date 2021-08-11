package za.ac.cput.services.login.features.queries;

/*
   @Subject: Project 3
   @Description:ILoginService.java
   @Author: Elrich Herman
   @Student Number: 218150040
   @Date: 07 August 2021
*/

import za.ac.cput.entity.Login;
import za.ac.cput.services.IService;
import java.util.Set;

public interface ILoginService extends IService<Login, String>
{
    Set<Login> getAll();
}