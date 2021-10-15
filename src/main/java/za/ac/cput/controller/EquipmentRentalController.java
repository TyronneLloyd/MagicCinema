package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.rent.EquipmentRental;
import za.ac.cput.services.EquipmentRentalService;
import java.util.List;

@RestController
@RequestMapping("/rental")
public class EquipmentRentalController {

    @Autowired
    EquipmentRentalService equipmentRentalService;

    //Get All
    @GetMapping("/getall")
    public List<EquipmentRental> getAll() {
        return equipmentRentalService.getAll();
    }

    //Get All By CustomerID
    @GetMapping("/getRentalsFromCustomerId/{customerId}")
    public List<EquipmentRental> getAllRentalByCustomerId(@PathVariable String customerId) {
        return equipmentRentalService.getRentalsFromCustomerId(customerId);
    }
    //Rent Item
    @PostMapping(name = "/rent")
    public EquipmentRental rent(@RequestBody EquipmentRental equipmentRental){
        return equipmentRentalService.create(equipmentRental);
    }

    //Return Item
    @PutMapping(value = "/return")
    public EquipmentRental update(@RequestBody EquipmentRental equipmentRental){
        return equipmentRentalService.update(equipmentRental);
    }
}
