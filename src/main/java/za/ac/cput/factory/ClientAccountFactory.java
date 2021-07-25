package za.ac.cput.factory;

/*
   @Subject: Project 3
   @Description:ClientAccountFactory.java
   @Author: Elrich Herman
   @Student Number: 218150040
   @Date: 4 June 2021
*/

import za.ac.cput.entity.ClientAccount;

public class ClientAccountFactory {

    public static ClientAccount createClientAccount(String accountNumber, String numberBorrowed){

        ClientAccount clientAccount = new ClientAccount.Builder()
                .setAccountNumber(accountNumber)
                .setNumberBorrowed(numberBorrowed)
                .build();
        return clientAccount;
    }
}
