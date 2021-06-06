package za.ac.cput.Factory;

/* @Subject: Project 3
   @Description:ClientFactoryTest.java
   @Author: Cole Hanekom
   @Student Number: 217267556
   @Date: 6 June 2021
  */

import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.Client;

import static org.junit.jupiter.api.Assertions.*;

class ClientFactoryTest {
    @Test
    public void createClient(){
        Client client = ClientFactory.createClient("John", "Johnson", "0711234560","100000000008");
        assertNotNull(client);
        System.out.println(client);
    }
}