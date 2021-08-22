package za.ac.cput.repository.equipmentStorage;

import za.ac.cput.entity.EquipmentStorageLog;
import za.ac.cput.repository.IRepository;

import java.util.Set;

public interface IEquipmentStorageLogRepository extends IRepository<EquipmentStorageLog, String> {
    Set<EquipmentStorageLog> getAll();
}
