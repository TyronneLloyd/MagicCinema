package za.ac.cput.Factory;

/*
   @Subject: Project 3
   @Description:ClientFactory.java
   @Author: Cole Hanekom
   @Student Number: 217267556
   @Date: 6 June 2021
 */

import za.ac.cput.Entity.Client;
import za.ac.cput.Util.GenericHelper;

public class ClientFactory {
    public static Client createClient(String name, String surname, String contactNumber, String accountNumber) {
        String clientID = GenericHelper.generateId();
        Client client = new Client.Builder()
                .setClientID(clientID)
                .setName(name)
                .setSurname(surname)
                .setContactNumber(contactNumber)
                .setAccountNumber(accountNumber)
                .build();

        return client;
    }
}
