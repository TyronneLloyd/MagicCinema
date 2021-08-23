package za.ac.cput.services;

/*
   @Subject: Project 3
   @Description:LoginService.java
   @Author: Elrich Herman
   @Student Number: 218150040
   @Date: 07 August 2021
*/

import za.ac.cput.entity.Login;
import za.ac.cput.repository.login.LoginRepository;
import za.ac.cput.services.login.ILoginService;
import java.util.Set;

public class LoginService implements ILoginService
{
    private static  LoginService service = null;
    private LoginRepository repository = null;

    private LoginService()
    {
        this.repository = LoginRepository.getRepository();
    }

    public static LoginService getService()
    {
        if(service == null){
            service = new LoginService();
        }
        return service;
    }

    @Override
    public Login create(Login login)
    {
        return this.repository.create(login);
    }

    @Override
    public Login read(String loginID)
    {
        return this.repository.read(loginID);
    }

    @Override
    public Login update(Login login)
    {
        return  this.repository.update(login);
    }

    @Override
    public boolean delete(String loginID)
    {
        return this.repository.delete(loginID);
    }

    @Override
    public Set<Login> getAll()
    {
        return (Set<Login>) this.repository.getAll();
    }

}