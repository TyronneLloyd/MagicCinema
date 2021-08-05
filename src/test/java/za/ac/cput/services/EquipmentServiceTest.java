package za.ac.cput.services;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.Equipment;
import za.ac.cput.factory.EquipmentFactory;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EquipmentServiceTest {
    private static EquipmentService service  = EquipmentService.getService();
    private static Equipment equipment = EquipmentFactory.createEquipment(
            "Camera","Cinema Camera","2001","XLH","Gauteng",399.99,true);
    @Test
    @Order(1)
    void create() {
        Equipment create = service.create(equipment);
        assertEquals(create.getEquipmentID(),equipment.getEquipmentID());
        System.out.println("Created: " + create);
        System.out.println(" ");
    }

    @Test
    @Order(2)
    void read() {
        Equipment read = service.read(equipment.getEquipmentID());
        assertNotNull(read);
        System.out.println("Read: " + read);
        System.out.println(" ");
    }

    @Test
    @Order(3)
    void update() {
       Equipment update = new Equipment.Builder().copy(equipment).setGearCategory("Generators").build();
        assertNotNull(service.update(update));
        System.out.println("Updated: " + update);
        System.out.println(" ");
    }

    @Test
    @Order(4)
    void delete() {
        boolean remove = service.delete(equipment.getEquipmentID());
        assertTrue(remove);
        System.out.println("Deleted: " + remove);
        System.out.println(" ");
    }

    @Test
    @Order(5)
    void getAll() {
        System.out.println("Display All: ");
        System.out.println(service.getAll());
        System.out.println(" ");
    }
}