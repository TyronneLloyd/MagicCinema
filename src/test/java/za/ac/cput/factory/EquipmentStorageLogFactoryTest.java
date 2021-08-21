package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.EquipmentStorageLog;

import static org.junit.jupiter.api.Assertions.*;

class EquipmentStorageLogFactoryTest {

    @Test
    void create() {
        EquipmentStorageLog storageLog = EquipmentStorageLogFactory.createEquipmentStorageLog(
                "Camera", "4321"
        );

        assertNotNull(storageLog);
        System.out.println(storageLog);
    }

}