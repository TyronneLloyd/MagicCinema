package za.ac.cput.repository.equipmentStorage;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.EquipmentStorageLog;
import za.ac.cput.factory.EquipmentStorageLogFactory;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EquipmentStorageLogRepositoryTest {

    public static EquipmentStorageLogRepository repository = EquipmentStorageLogRepository.getRepository();
    public static EquipmentStorageLog storageLog = EquipmentStorageLogFactory.createEquipmentStorageLog(
            "Camera", "4321"
    );

    @Test
    @Order(1)
    void create() {
        EquipmentStorageLog create = repository.create(storageLog);
        assertEquals(create.getEquipmentStorageLogId(), storageLog.getEquipmentStorageLogId());
        System.out.println("Created: " + create);
    }

    @Test
    @Order(2)
    void read() {
        EquipmentStorageLog read = repository.read(storageLog.getEquipmentStorageLogId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    @Order(3)
    void update() {
        EquipmentStorageLog updated = new EquipmentStorageLog.Builder().copy(storageLog).setEquipmentStorageCategory("Microphones").build();
        assertNotNull(repository.update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    @Order(5)
    void delete() {
        boolean success = repository.delete(storageLog.getEquipmentStorageLogId());
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }

    @Test
    @Order(4)
    void getAll() {
        System.out.println("Display All: "  + repository.getAll());

    }

}