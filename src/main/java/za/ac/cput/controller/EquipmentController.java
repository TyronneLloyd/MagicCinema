package za.ac.cput.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.ClientAccount;
import za.ac.cput.entity.Equipment;
import za.ac.cput.factory.EquipmentFactory;
import za.ac.cput.services.EquipmentService;

import java.util.Set;
@RestController
@RequestMapping("/equipment")
public class EquipmentController {
    @Autowired
    private EquipmentService service;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Equipment create(@RequestBody Equipment equipmentID)
    {
        Equipment newEquipment = EquipmentFactory.createEquipment("Camera","Cinema Lights"
        ,"OPGQ","2019","Pretoria",599.69,true);
        return service.create(newEquipment);
    }
    @GetMapping("/read")
    public Equipment read (@RequestBody Equipment equipment)
    {
        return service.read(equipment.getEquipmentID());
    }
    @PostMapping("/update")
    public Equipment update (@RequestBody Equipment equipment)
    {
        return service.update(equipment);
    }
    @DeleteMapping("/delete/{accountNum}")
    public boolean delete(@PathVariable String equipmentID)
    {
        return service.delete(equipmentID);
    }


    @GetMapping("/getAllEquipmentRented")
    public Set<Equipment>getAll()
    {
        return service.getAll();
    }



}
