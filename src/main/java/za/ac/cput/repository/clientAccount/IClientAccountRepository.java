package za.ac.cput.repository.clientAccount;

import za.ac.cput.entity.ClientAccount;
import za.ac.cput.repository.IRepository;
import java.util.*;

public interface IClientAccountRepository extends IRepository<ClientAccount, String>
{
    List<ClientAccount> getAll();
}