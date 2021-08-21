package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.EquipmentStorage;
import za.ac.cput.factory.EquipmentStorageFactory;
import za.ac.cput.services.EquipmentStorageService;

import java.util.Set;

@RestController
@RequestMapping("/equipmentstorage")
public class EquipmentStorageController {

    @Autowired
    private EquipmentStorageService equipmentStorageService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public EquipmentStorage create(@RequestBody EquipmentStorage equipmentStorage){
        EquipmentStorage newStorage = EquipmentStorageFactory.createStorageFactory(
                equipmentStorage.getShelfSpace(),
                equipmentStorage.getShelfSpace());

        return equipmentStorageService.create(newStorage);
    }

    @RequestMapping(value = "/read/{equipmentID}", method = RequestMethod.GET)
    public EquipmentStorage read(@PathVariable String equipmentID){
        return equipmentStorageService.read(equipmentID);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public EquipmentStorage update(@RequestBody EquipmentStorage equipmentStorage){
        EquipmentStorage newEquipmentStorage = new EquipmentStorage.Builder().copy(equipmentStorage)
                .ShelfSpace(equipmentStorage.getShelfSpace()).build();
        return equipmentStorageService.update(newEquipmentStorage);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public boolean delete(@RequestBody EquipmentStorage equipmentStorage){
        if(equipmentStorageService.delete(equipmentStorage.getEquipmentID()))
            return true;
        else {
            return false;
        }
    }

    @RequestMapping(value = "/getall", method = RequestMethod.GET)
    public Set<EquipmentStorage> getAll(){
        return equipmentStorageService.getAll();
    }
}
