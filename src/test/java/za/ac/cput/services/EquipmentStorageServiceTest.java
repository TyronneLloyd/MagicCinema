package za.ac.cput.services;
/*
    @Description:Repository ->
    @Author: Tyronne Lloyd Hendricks
    @Student Number: 215141210
    @Date: 03 August 2021
*/

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.EquipmentStorage;
import za.ac.cput.factory.EquipmentStorageFactory;
import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class EquipmentStorageServiceTest {
private  static EquipmentStorageService service = EquipmentStorageService.getService();
private static EquipmentStorage equipmentStorage = EquipmentStorageFactory.createStorageFactory("24","11000");
    @Test
    @Order(1)
    void create() {
         EquipmentStorage create = service.create(equipmentStorage);
         assertEquals(create.getEquipmentID(), equipmentStorage.getEquipmentID());
        System.out.println("Created: " + create);
    }

    @Test
    @Order(2)
    void read() {
        EquipmentStorage read = service.read(equipmentStorage.getEquipmentID());
        assertNotNull(read);
        System.out.println("Read:" + read);

    }

    @Test
    @Order(3)
    void update() {
        EquipmentStorage update = new EquipmentStorage.Builder().copy(equipmentStorage).ShelfSpace("23").build();
        assertNotNull(service.update(update));
        System.out.println("Updated: " + update);
    }

    @Test
    @Order(5)
    void delete() {
        boolean success;
        success = service.delete(equipmentStorage.getEquipmentID());
        assertTrue(success);
        System.out.println("Deleted: "+ success);
    }

    @Test
    @Order(4)
    void getAll() {
        System.out.println("Display All: ");
        System.out.println(service.getAll());
    }
}