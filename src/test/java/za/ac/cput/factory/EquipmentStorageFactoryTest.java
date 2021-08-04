package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.EquipmentStorage;

import static org.junit.jupiter.api.Assertions.*;

class EquipmentStorageFactoryTest {

    @Test
    void createEquipmentStorage() {
        EquipmentStorage storage = EquipmentStorageFactory.createStorageFactory("24", "11000");

        assertNotNull(storage);
        System.out.println(storage);
    }

}