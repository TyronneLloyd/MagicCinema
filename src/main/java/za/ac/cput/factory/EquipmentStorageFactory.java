package za.ac.cput.factory;

import za.ac.cput.entity.EquipmentStorage;

public class EquipmentStorageFactory {
    public static EquipmentStorage createStorageFactory(String shelfSpace, String equipmentID){

        EquipmentStorage equipmentStorage = new EquipmentStorage.Builder()
                .ShelfSpace(shelfSpace)
                .EquipmentID(equipmentID)
                .build();

        return equipmentStorage;

    }
}
