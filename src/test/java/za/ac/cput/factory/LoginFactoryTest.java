package za.ac.cput.factory;

/*
   @Subject: Project 3
   @Description:LoginFactoryTest.java
   @Author: Elrich Herman
   @Student Number: 218150040
   @Date: 4 June 2021
*/

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Login;
import static org.junit.jupiter.api.Assertions.*;

public class LoginFactoryTest {

    @Test
    public void createLogin() {
        Login login = LoginFactory.createLogin("Human894546");
        assertNotNull(login);
        System.out.println(login);
    }
}
