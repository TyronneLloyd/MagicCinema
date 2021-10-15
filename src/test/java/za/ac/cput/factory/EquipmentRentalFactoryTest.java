package za.ac.cput.factory;

/*
    @Description: EquipmentRentalFactoryTest.java
    @Author: Grant Hendricks
    @Student Number: 215138848
    @Date: 5 June 2021
  */

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.rent.EquipmentRental;

import static org.junit.jupiter.api.Assertions.*;

class EquipmentRentalFactoryTest {

    @Test void test(){
        EquipmentRental equipmentRental = EquipmentRentalFactory.createEquipmentRental("client","equipment",
                "0012","09/10/2021",null,10.50, 0,
                0, 4, 1250, 0);
        System.out.println(equipmentRental);
        assertNotNull(equipmentRental);

    }

}