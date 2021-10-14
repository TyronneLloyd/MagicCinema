package za.ac.cput.factory;

import za.ac.cput.entity.EquipmentStorage;
import za.ac.cput.entity.catalog.EquipmentCategory;

public class EquipmentCategoryFactory {
    public static EquipmentCategory createEquipmentCategoryFactory(String id, String title){

        EquipmentCategory equipmentCategory = new EquipmentCategory.Builder()
                .setGearCategoryID(id)
                .setCategoryTitle(title)
                .build();

        return equipmentCategory;

    }
}
