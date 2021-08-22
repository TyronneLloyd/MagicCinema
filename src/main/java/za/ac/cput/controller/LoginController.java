package za.ac.cput.controller;

/*
   @Subject: Project 3
   @Description:LoginController.java
   @Author: Elrich Herman
   @Student Number: 218150040
   @Date: 19 June 2021
*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.Login;
import za.ac.cput.factory.LoginFactory;
import za.ac.cput.services.LoginService;

import java.util.Set;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Login create(@RequestBody Login login){
        Login newLogin = LoginFactory.createLogin(login.getPassword());
        return loginService.create(newLogin);
    }

    @RequestMapping(value = "/read/{password}", method = RequestMethod.GET)
    public Login read(@PathVariable String password){
        return loginService.read(password);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Login update(@RequestBody Login login){
        Login newLogin = new Login.Builder().copy(login)
                .Password(login.getPassword()).build();
        return loginService.update(newLogin);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public boolean delete(@RequestBody Login login){
        if(loginService.delete(login.getPassword()))
            return true;
        else {
            return false;
        }
    }

    @RequestMapping(value = "/getall", method = RequestMethod.GET)
    public Set<Login> getAll(){
        return loginService.getAll();
    }
}
