package za.ac.cput.repository.client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.entity.Client;
import za.ac.cput.repository.IRepository;
import java.util.Set;

@Repository
public interface ClientRepository extends JpaRepository<Client, String> {
}
