package za.ac.cput.factory;
/*  @Subject: Project 3
    @Description: Equipment Factory TDD
    @Author: Asiphiwe Hanjiwe
    @Student Number: 218336675
    @Date: 07 June 2021
  */
import org.junit.jupiter.api.Test;
import za.ac.cput.entity.catalog.Equipment;

import static org.junit.jupiter.api.Assertions.*;

class EquipmentFactoryTest {
    @Test
    public void createEquipment()
    {
        Equipment equipment = EquipmentFactory.createEquipment("CAM12","Camera","Cinema Cameras",
                "2019","camera12XVY","Cape Town",3,120.0, "");
        System.out.println(equipment);
        assertNotNull(equipment);
    }

}