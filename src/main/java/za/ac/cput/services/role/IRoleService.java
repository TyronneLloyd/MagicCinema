package za.ac.cput.services.role;

import za.ac.cput.entity.Role;
import za.ac.cput.services.IService;

import java.util.Set;

public interface IRoleService extends IService<Role, Integer> {
    Set<Role> getAll();
}
