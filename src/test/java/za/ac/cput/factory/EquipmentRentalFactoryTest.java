package za.ac.cput.factory;

/*
    @Description: EquipmentRentalFactoryTest.java
    @Author: Grant Hendricks
    @Student Number: 215138848
    @Date: 5 June 2021
  */

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.EquipmentRental;

import static org.junit.jupiter.api.Assertions.*;

class EquipmentRentalFactoryTest {

    @Test void test(){
        EquipmentRental equipmentRental = EquipmentRentalFactory.createEquipmentRental("client","equipment","0012","start","end","end", 80.5, 4, 20);
        System.out.println(equipmentRental);
        assertNotNull(equipmentRental);

    }

}