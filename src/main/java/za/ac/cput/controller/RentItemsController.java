package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.Employee;
import za.ac.cput.entity.rent.RentItems;
import za.ac.cput.services.CartService;
import za.ac.cput.services.EquipmentService;
import za.ac.cput.services.RentItemsService;

import java.util.Set;

@RestController
@RequestMapping("/rentitems")
public class RentItemsController {

    @Autowired
    private RentItemsService rentItemsService;

    @Autowired
    private CartService cartService;

    @Autowired
    private EquipmentService equipmentService;

    @PostMapping(value = "/create")
    public RentItems create(@RequestBody RentItems rentItems){
        cartService.updateCartStatusByCustomerId(rentItems.getClient());
        equipmentService.removeEquipmentQuantityById(rentItems.getEquipment(), rentItems.getQuantity());
        return rentItemsService.create(rentItems);
    }

    @GetMapping(value = "/read/{id}")
    public ResponseEntity<RentItems> read(@PathVariable int id){
        RentItems readRental = rentItemsService.read(id);
        return new ResponseEntity<>(readRental, HttpStatus.OK);
    }

    @PutMapping(value = "/update")
    public RentItems update(@RequestBody RentItems rentItems){
        equipmentService.addEquipmentQuantityById(rentItems.getEquipment(), rentItems.getQuantity());
        return rentItemsService.update(rentItems);

    }

    @RequestMapping(value = "/getall", method = RequestMethod.GET)
    public ResponseEntity<Set<RentItems>> getAll(){
        Set<RentItems> rentItems = rentItemsService.getAll();
        return new ResponseEntity<>(rentItems, HttpStatus.OK);
    }

    @GetMapping(value = "/getRentalByCustomer/{customerId}")
    public ResponseEntity<Set<RentItems>> getRentalByCustomer(@PathVariable String customerId){
        Set<RentItems> rentItems = rentItemsService.getRentalsFromCustomerId(customerId);
        return new ResponseEntity<>(rentItems, HttpStatus.OK);
    }
}
