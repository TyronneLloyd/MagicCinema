package za.ac.cput.Factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.EquipmentStorage;

import static org.junit.jupiter.api.Assertions.*;

class EquipmentStorageFactoryTest {

    @Test
    void CreateStorageFactory() {
        EquipmentStorage equipmentStorage = EquipmentStorageFactory.createStorageFactory("24", "10001");

        assertNotNull(equipmentStorage);
    }

}