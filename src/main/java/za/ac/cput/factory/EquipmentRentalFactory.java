package za.ac.cput.factory;
/*
    @Description: EquipmentRentalFactory.java -> EquipmentRentalFactory class
    @Author: Grant Hendricks
    @Student Number: 215138848
    @Date: 4 June 2021
  */

import za.ac.cput.entity.EquipmentRental;
import za.ac.cput.util.GenericHelper;

public class EquipmentRentalFactory {
    public static EquipmentRental createEquipmentRental(String clientID, String equipmentID, String employeeNumber, String rentalStartDate, String rentalEndDate){
        String rentalID = GenericHelper.generateId();

        EquipmentRental equipmentRental = new EquipmentRental.Builder()
                .setRentalID(rentalID)
                .setClientID(clientID)
                .setEquipmentID(equipmentID)
                .setEmployeeNumber(employeeNumber)
                .setRentalStartDate(rentalStartDate)
                .setRentalEndDate(rentalEndDate)
                .build();

        return equipmentRental;
    }

}
