package za.ac.cput.services.equipmentStorage;

import za.ac.cput.entity.EquipmentStorageLog;
import za.ac.cput.services.IService;
import java.util.Set;

public interface IEquipmentStorageLogService extends IService<EquipmentStorageLog, String> {
    Set<EquipmentStorageLog> getAll();
}
