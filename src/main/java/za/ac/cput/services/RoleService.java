package za.ac.cput.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.Role;
import za.ac.cput.repository.role.RoleRepository;
import za.ac.cput.services.role.IRoleService;
import javax.persistence.EntityNotFoundException;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RoleService implements IRoleService {
    private RoleRepository repository;

    @Autowired
    public RoleService(RoleRepository repository) {
        this.repository = repository;
    }

    @Override
    public Role create(Role role) {
        return this.repository.save(role);
    }

    @Override
    public Role read(Integer roleId) {
        return this.repository.findById(roleId).orElseThrow(() -> new EntityNotFoundException("Role with id " + roleId + " was not found" ));
    }

    @Override
    public Role update(Role role) {
        if(this.repository.existsById(role.getId()))
            return this.repository.save(role);
        return null;
    }

    @Override
    public boolean delete(Integer roleId) {
       this.repository.deleteById(roleId);
       if(this.repository.existsById(roleId))
           return false;
       else
           return true;
    }

    @Override
    public Set<Role> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }
}
