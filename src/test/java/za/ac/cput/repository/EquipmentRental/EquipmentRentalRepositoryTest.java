package za.ac.cput.repository.EquipmentRental;

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
class EquipmentRentalRepositoryTest {
    private static EquipmentRentalRepository repository = EquipmentRentalRepository.getRepository();
    private static EquipmentRental equipmentRental = EquipmentRentalFactory.createEquipmentRental("client","equipment","0012","start","end");

    @Test
    @Order(1)
    void create() {
        EquipmentRental create = repository.create(equipmentRental);
        assertEquals(create.getRentalID(), equipmentRental.getRentalID());
        System.out.println("Created: " + create );
    }

    @Test
    @Order(2)
    void read() {
        EquipmentRental read = repository.read(equipmentRental.getRentalID());
        assertNotNull(read);
        System.out.println("Created: " + read );
    }

    @Test
    @Order(3)
    void update() {
        EquipmentRental updated = new EquipmentRental.Builder().copy(equipmentRental).setRentalEndDate("22-August-2021").build();
        assertNotNull(repository.update(updated));
        System.out.println("Updated: " + updated );
    }

    @Test
    @Order(5)
    void delete() {
        boolean success = repository.delete(equipmentRental.getRentalID());
        assertTrue(success);
        System.out.println("Deleted: " + success );
    }

    @Test
    @Order(4)
    void getAll() {
        System.out.println("Display All: "  + repository.getAll());
    }
}