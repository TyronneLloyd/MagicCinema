package za.ac.cput.repository.role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.entity.Role;

import java.util.Set;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
}
