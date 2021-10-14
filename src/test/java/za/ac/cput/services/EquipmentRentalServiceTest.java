package za.ac.cput.services;

/*
    @Description: Test Class
    @Author: Grant Hendricks
    @Student Number: 215138848
    @Date: 11 August 2021
  */

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.EquipmentRental;
import za.ac.cput.factory.EquipmentRentalFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EquipmentRentalServiceTest {
    private EquipmentRentalService service = EquipmentRentalService.getService();
    private static EquipmentRental equipmentRental = EquipmentRentalFactory.createEquipmentRental("client","equipment","0012","start","end", "end", 80.5, 4, 20);

    @Test
    @Order(1)
    void create() {
        EquipmentRental create = service.create(equipmentRental);
        assertEquals(create.getRentalID(), equipmentRental.getRentalID());
        System.out.println("Created: " + create);
    }

    @Test
    @Order(2)
    void read() {
        EquipmentRental read = service.read(equipmentRental.getRentalID());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    @Order(3)
    void update() {
        EquipmentRental update = new EquipmentRental.Builder().copy(equipmentRental).setRentalEndDate("22-August-2021").build();
        assertNotNull(service.update(update));
        System.out.println("Updated: " + update);
    }

    @Test
    @Order(5)
    void delete() {
        boolean success = service.delete(equipmentRental.getRentalID());
        assertTrue(success);
        System.out.println("Delete: " + success);
    }

    @Test
    @Order(4)
    void getAll() {
        System.out.println("Display All: "  + service.getAll());
    }
}