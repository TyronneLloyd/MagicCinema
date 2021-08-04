package za.ac.cput.repository.equipmentStorage;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.EquipmentStorage;
import za.ac.cput.factory.EquipmentStorageFactory;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EquipmentStorageRepositoryTest {
    private static EquipmentStorageRepository repository = EquipmentStorageRepository.getRepository();
    private static EquipmentStorage equipmentStorage = EquipmentStorageFactory.createStorageFactory("21", "11001");

    @Test
    @Order(1)
    void create() {
        EquipmentStorage create = repository.create(equipmentStorage);
        assertEquals(create.getEquipmentID(), equipmentStorage.getEquipmentID());
        System.out.println("Created: " + create);
    }

    @Test
    @Order(2)
    void read() {
        EquipmentStorage read = repository.read(equipmentStorage.getEquipmentID());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    @Order(3)
    void update() {
        EquipmentStorage updated = new EquipmentStorage.Builder().copy(equipmentStorage).ShelfSpace("22").build();
        assertNotNull(repository.update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    @Order(5)
    void delete() {
        boolean success = repository.delete(equipmentStorage.getEquipmentID());
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }

    @Test
    @Order(4)
    void getAll() {
        System.out.println("Display All: "  + repository.getAll());

    }
}