package za.ac.cput.repository.equipmentStorage;
import za.ac.cput.entity.EquipmentStorageLog;
import java.util.HashSet;
import java.util.Set;

public class EquipmentStorageLogRepository implements IEquipmentStorageLogRepository{
    private static EquipmentStorageLogRepository repository = null;
    private Set<EquipmentStorageLog> equipmentStorageLogDS = null;

    private EquipmentStorageLogRepository(){
        equipmentStorageLogDS = new HashSet<EquipmentStorageLog>();
    }
    public static  EquipmentStorageLogRepository getRepository(){
        if(repository == null){
            repository = new EquipmentStorageLogRepository();
        }
        return  repository;
    }

    @Override
    public EquipmentStorageLog read(String storageLogId) {
        for (EquipmentStorageLog esl : equipmentStorageLogDS) {
            if (esl.getEquipmentStorageLogId().equalsIgnoreCase(storageLogId)) {
                return esl;
            }
        }
        return null;
    }

    @Override
    public EquipmentStorageLog create(EquipmentStorageLog equipmentStorageLog) {
        boolean success = equipmentStorageLogDS.add(equipmentStorageLog);
        if(!success)
            return null;
        return equipmentStorageLog;
    }

    @Override
    public EquipmentStorageLog update(EquipmentStorageLog equipmentStorageLog) {
        EquipmentStorageLog oldLog = read(equipmentStorageLog.getEquipmentStorageLogId());
        if(oldLog != null){
            equipmentStorageLogDS.remove(oldLog);
            equipmentStorageLogDS.add(equipmentStorageLog);
            return equipmentStorageLog;
        }
        return null;
    }

    @Override
    public boolean delete(String storageLogId) {
        EquipmentStorageLog removeLog  = read(storageLogId);
        if(removeLog == null)
            return false;
        equipmentStorageLogDS.remove(removeLog);
        return true;
    }

    @Override
    public Set<EquipmentStorageLog> getAll() {
        return equipmentStorageLogDS;
    }
}
