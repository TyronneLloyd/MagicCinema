package za.ac.cput.repository.clientAccount;

/*
   @Subject: Project 3
   @Description:IClientAccountRepository.java
   @Author: Elrich Herman
   @Student Number: 218150040
   @Date: 07 August 2021
*/

import za.ac.cput.entity.ClientAccount;
import java.util.*;

public class ClientAccountRepository implements IClientAccountRepository
        {
        private static za.ac.cput.repository.clientAccount.ClientAccountRepository repository = null;
        private Set<ClientAccount> clientAccountDBS = null;
        private ClientAccountRepository(){clientAccountDBS = new HashSet<ClientAccount>();

        }

        public static za.ac.cput.repository.clientAccount.ClientAccountRepository getRepository(){
            if(repository == null)
            {
                repository = new za.ac.cput.repository.clientAccount.ClientAccountRepository();
            }
            return  repository;
        }
        @Override
        public ClientAccount create(ClientAccount clientAccount)
        {
            boolean success = clientAccountDBS.add(clientAccount);
            if(!success)
                return null;
            return clientAccount;
        }
        @Override
        public ClientAccount read(String clientID) {
            for (ClientAccount ca : clientAccountDBS)
            {
                if (ca.getAccountNumber().equalsIgnoreCase(clientID))
                {
                    return ca;
                }
            }
            return null;
        }

        @Override
        public ClientAccount update(ClientAccount clientAccount)
        {
            ClientAccount UP = read(clientAccount.getAccountNumber());
            if(UP != null)
            {
                clientAccountDBS.remove(UP);
                clientAccountDBS.add(clientAccount);
                return clientAccount;
            }
            return null;
        }


        @Override
        public boolean delete(String clientID)
        {
            ClientAccount clientAccountRemove  = read(clientID);
            if(clientAccountRemove == null)
                return false;
            clientAccountDBS.remove(clientAccountRemove);
            return true;
        }


        @Override
        public List<ClientAccount> getAll() {
            return null;
        }
    }


