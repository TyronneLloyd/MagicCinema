package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.Role;
import za.ac.cput.factory.RoleFactory;
import za.ac.cput.services.RoleService;

import java.util.Set;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService service;

    @PostMapping(value = "/create")
    public ResponseEntity<Role> create(@RequestBody Role role){
        Role newRole = service.create(
                RoleFactory.createRole(
                        role.getTitle(),
                        role.getDescription()
                ));
        return new ResponseEntity<>(newRole, HttpStatus.CREATED);

    }

    @GetMapping(value = "/read/{roleId}")
    public ResponseEntity<Role> read(@PathVariable("roleId") int roleId){
        Role role = service.read(roleId);
        return new ResponseEntity<>(role, HttpStatus.OK);
    }

    @PutMapping(value = "/update")
    public ResponseEntity<Role> update(@RequestBody Role role){

        Role newRole = new Role.Builder().copy(role)
                .setTitle(role.getTitle()).setDescription(role.getDescription()).build();
        Role updateRole = service.update(newRole);

        return new ResponseEntity<>(updateRole, HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{roleId}")
    public ResponseEntity<?> delete(@PathVariable("roleId") int roleId){
        service.delete(roleId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/getall")
    public ResponseEntity<Set<Role>> getAll(){
        Set<Role> roles = service.getAll();
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }
}
