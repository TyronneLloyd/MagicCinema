package za.ac.cput.services;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.EquipmentStorageLog;
import za.ac.cput.factory.EquipmentStorageLogFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EquipmentStorageLogServiceTest {
    private static EquipmentStorageLogService service  = EquipmentStorageLogService.getService();
    public static EquipmentStorageLog storageLog = EquipmentStorageLogFactory.createEquipmentStorageLog(
            "Camera", "4321"
    );

    @Test
    @Order(1)
    void create() {
        EquipmentStorageLog create = service.create(storageLog);
        assertEquals(create.getEquipmentStorageLogId(),storageLog.getEquipmentStorageLogId());
        System.out.println("Created: " + create);
        System.out.println(" ");
    }

    @Test
    @Order(2)
    void read() {
        EquipmentStorageLog read = service.read(storageLog.getEquipmentStorageLogId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    @Order(3)
    void update() {
        EquipmentStorageLog update = new EquipmentStorageLog.Builder().copy(storageLog).setEquipmentStorageCategory("HD-Camera").build();
        assertNotNull(service.update(update));
        System.out.println("Updated: " + update);
    }

    @Test
    @Order(4)
    void delete() {
        boolean remove = service.delete(storageLog.getEquipmentStorageLogId());
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