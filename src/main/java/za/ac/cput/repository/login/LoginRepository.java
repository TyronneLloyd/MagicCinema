package za.ac.cput.repository.login;

/*
   @Subject: Project 3
   @Description:ILoginRepository.java
   @Author: Elrich Herman
   @Student Number: 218150040
   @Date: 07 August 2021
*/

import za.ac.cput.entity.Login;
import java.util.*;

public class LoginRepository implements ILoginRepository
{
    private static za.ac.cput.repository.login.LoginRepository repository = null;
    private Set<Login> loginDBS = null;
    private LoginRepository()
    {
        loginDBS = new HashSet<Login>();
    }

    public static za.ac.cput.repository.login.LoginRepository getRepository(){
        if(repository == null)
        {
            repository = new za.ac.cput.repository.login.LoginRepository();
        }
        return  repository;
    }
    @Override
    public Login create(Login login){
        boolean success = loginDBS.add(login);
        if(!success)
            return null;
        return login;
    }
    @Override
    public Login read(String loginID) {
        for (Login lo : loginDBS) {
            if (lo.getPassword().equalsIgnoreCase(loginID)) {
                return lo;
            }
        }
        return null;
    }

    @Override
    public Login update(Login login) {
        Login UP = read(login.getPassword());
        if(UP != null){
            loginDBS.remove(UP);
            loginDBS.add(login);
            return login;
        }
        return null;
    }


    @Override
    public boolean delete(String loginID) {
        Login loginRemove  = read(loginID);
        if(loginRemove == null)
            return false;
        loginDBS.remove(loginRemove);
        return true;
    }


    @Override
    public List<Login> getAll() {
        return null;
    }
}