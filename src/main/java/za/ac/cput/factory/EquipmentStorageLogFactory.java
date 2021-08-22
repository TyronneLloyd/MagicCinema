package za.ac.cput.factory;

import za.ac.cput.entity.EquipmentStorageLog;
import za.ac.cput.util.GenericHelper;

public class EquipmentStorageLogFactory {
    public static EquipmentStorageLog createEquipmentStorageLog(String equipmentStorageCategory, String equipmentStorageLocation) {
        String equipmentStorageLogId = GenericHelper.generateId();
        EquipmentStorageLog equipmentStorageLog = new EquipmentStorageLog.Builder()
                .setEquipmentStorageLogId(equipmentStorageLogId)
                .setEquipmentStorageCategory(equipmentStorageCategory)
                .setEquipmentStorageLocation(equipmentStorageLocation)
                .build();

        return equipmentStorageLog;
    }
}
