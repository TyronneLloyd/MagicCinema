package za.ac.cput.Factory;

/*
   @Subject: Project 3
   @Description:LoginFactory.java
   @Author: Elrich Herman
   @Student Number: 218150040
   @Date: 4 June 2021
*/

import za.ac.cput.Entity.Login;

public class LoginFactory {

    public static Login createLogin(String password){

        Login login = new Login.Builder()
                .setPassword(password)
                .build();
        return login;
    }

}
