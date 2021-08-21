package za.ac.cput.services;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.EquipmentStorage;
import za.ac.cput.factory.EquipmentStorageFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EquipmentStorageServiceTest {
    private static EquipmentStorageService service = EquipmentStorageService.getService();
    private static EquipmentStorage equipmentStorage = EquipmentStorageFactory.createStorageFactory("21", "11001");

    @Test
    @Order(1)
    void create() {
        EquipmentStorage create = service.create(equipmentStorage);
        assertEquals(create.getEquipmentID(),equipmentStorage.getEquipmentID());
        System.out.println("Created: " + create);
        System.out.println(" ");
    }

    @Test
    @Order(2)
    void read() {
        EquipmentStorage read = service.read(equipmentStorage.getEquipmentID());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    @Order(3)
    void update() {
        EquipmentStorage update = new EquipmentStorage.Builder().copy(equipmentStorage).ShelfSpace("12").build();
        assertNotNull(service.update(update));
        System.out.println("Updated: " + update);
    }

    @Test
    @Order(4)
    void delete() {
        boolean remove = service.delete(equipmentStorage.getEquipmentID());
        assertTrue(remove);
        System.out.println("Deleted: " + remove);
    }

    @Test
    @Order(5)
    void getAll() {
        System.out.println("Display All: ");
        System.out.println(service.getAll());
        System.out.println(" ");
    }
}