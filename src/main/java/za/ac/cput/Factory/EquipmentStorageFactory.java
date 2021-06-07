package za.ac.cput.Factory;

import za.ac.cput.Entity.EquipmentStorage;

public class EquipmentStorageFactory {
    public static EquipmentStorage createStorageFactory(String shelfSpace, String equipmentID){

        EquipmentStorage equipmentStorage = new EquipmentStorage.Builder()
                .ShelfSpace(shelfSpace)
                .EquipmentID(equipmentID)
                .build();

        return equipmentStorage;
    }
}
