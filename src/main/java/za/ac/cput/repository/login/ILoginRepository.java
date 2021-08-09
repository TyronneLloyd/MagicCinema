package za.ac.cput.repository.login;

import za.ac.cput.repository.IRepository;
import za.ac.cput.entity.Login;
import java.util.List;

public interface ILoginRepository extends IRepository<Login, String>
{
    List<Login> getAll();
}
