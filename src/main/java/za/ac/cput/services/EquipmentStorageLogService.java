package za.ac.cput.services;

import org.springframework.stereotype.Service;
import za.ac.cput.entity.EquipmentStorageLog;
import za.ac.cput.repository.equipmentStorage.EquipmentStorageLogRepository;
import za.ac.cput.repository.equipmentStorage.EquipmentStorageRepository;
import za.ac.cput.services.equipmentStorage.IEquipmentStorageLogService;

import java.util.Set;

@Service
public class EquipmentStorageLogService implements IEquipmentStorageLogService {
    private static  EquipmentStorageLogService service = null;
    private EquipmentStorageLogRepository repository = null;

    private EquipmentStorageLogService(){
        this.repository = EquipmentStorageLogRepository.getRepository();
    }
    public static EquipmentStorageLogService getService(){
        if(service == null){
            service = new EquipmentStorageLogService();
        }
        return service;
    }
    @Override
    public EquipmentStorageLog create(EquipmentStorageLog equipmentStorageLog) {
        return this.repository.create(equipmentStorageLog);
    }

    @Override
    public EquipmentStorageLog read(String storageLogId) {
        return this.repository.read(storageLogId);
    }

    @Override
    public EquipmentStorageLog update(EquipmentStorageLog equipmentStorageLog) {
        return  this.repository.update(equipmentStorageLog);
    }

    @Override
    public boolean delete(String storageLogId) {
        return this.repository.delete(storageLogId);
    }

    @Override
    public Set<EquipmentStorageLog> getAll() {
        return this.repository.getAll();
    }
}
