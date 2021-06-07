package za.ac.cput.Factory;

/*
   @Subject: Project 3
   @Description:ClientAccountFactoryTest.java
   @Author: Elrich Herman
   @Student Number: 218150040
   @Date: 4 June 2021
*/

import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.ClientAccount;
import static org.junit.jupiter.api.Assertions.*;

public class ClientAccountFactoryTest {

    @Test
    public void createClientAccount() {
        ClientAccount clientAccount = ClientAccountFactory.createClientAccount("55684465", "5");
        assertNotNull(clientAccount);
        System.out.println(clientAccount);
    }

}
