package za.ac.cput.services;

import org.springframework.stereotype.Service;
import za.ac.cput.entity.EquipmentStorage;
import za.ac.cput.repository.equipmentStorage.EquipmentStorageRepository;
import za.ac.cput.services.equipmentStorage.IEquipmentStorageService;
import java.util.Set;

@Service
public class EquipmentStorageService implements IEquipmentStorageService{
    private static  EquipmentStorageService service = null;
    private EquipmentStorageRepository repository = null;

    private EquipmentStorageService(){
        this.repository = EquipmentStorageRepository.getRepository();
    }

    public static EquipmentStorageService getService(){
        if(service == null){
            service = new EquipmentStorageService();
        }
        return service;
    }
    @Override
    public EquipmentStorage create(EquipmentStorage equipmentStorage){
        return this.repository.create(equipmentStorage);
    }
    @Override
    public EquipmentStorage read(String equipmentStorageId){
        return this.repository.read(equipmentStorageId);

    }

    @Override
    public EquipmentStorage update(EquipmentStorage equipmentStorage){
        return  this.repository.update(equipmentStorage);
    }

    @Override
    public boolean delete(String equipmentStorageId){
        return this.repository.delete(equipmentStorageId);
    }
    @Override
    public Set<EquipmentStorage> getAll(){
        return (Set<EquipmentStorage>) this.repository.getAll();
    }

}
