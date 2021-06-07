package za.ac.cput.Factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.Equipment;

import static org.junit.jupiter.api.Assertions.*;

class EquipmentFactoryTest {
    @Test
    public void createEquipment()
    {
        Equipment equipment = EquipmentFactory.createEquipment("Camera","Cinema Cameras",
                "2019","camera12XVY","Cape Town",120.0,true);
        System.out.println(equipment);
        assertNotNull(equipment);
    }

}