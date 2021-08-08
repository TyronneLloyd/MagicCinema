package za.ac.cput.repository.equipmentStorage;
/*
    @Description:Repository ->
    @Author: Tyronne Lloyd Hendricks
    @Student Number: 215141210
    @Date: 03 August 2021
*/

import za.ac.cput.entity.EquipmentStorage;
import java.util.HashSet;
import java.util.Set;

public class EquipmentStorageRepository implements IEquipmentStorageRepository{
    private static EquipmentStorageRepository repository = null;
    private Set<EquipmentStorage> equipmentStorageDS = null;
    private EquipmentStorageRepository(){equipmentStorageDS = new HashSet<EquipmentStorage>();
    }

    public static  EquipmentStorageRepository getRepository(){
        if(repository == null){
            repository = new EquipmentStorageRepository();
        }
        return  repository;
    }
    @Override
    public EquipmentStorage create(EquipmentStorage equipmentStorage){
        boolean success = equipmentStorageDS.add(equipmentStorage);
        if(!success)
            return null;
        return equipmentStorage;
    }
    @Override
    public EquipmentStorage read(String equipmentStorageId) {
        for (EquipmentStorage es : equipmentStorageDS) {
            if (es.getEquipmentID().equalsIgnoreCase(equipmentStorageId)) {
                return es;
            }
        }
        return null;
    }

    @Override
    public EquipmentStorage update(EquipmentStorage equipmentStorage) {
       EquipmentStorage oldEs = read(equipmentStorage.getEquipmentID());
       if(oldEs != null){
           equipmentStorageDS.remove(oldEs);
           equipmentStorageDS.add(equipmentStorage);
           return equipmentStorage;
       }
       return null;
    }


    @Override
    public boolean delete(String equipmentStorageId) {
        EquipmentStorage equipmentStorageRemoved  = read(equipmentStorageId);
        if(equipmentStorageRemoved == null)
            return false;
        equipmentStorageDS.remove(equipmentStorageRemoved);
        return true;
    }


    @Override
    public Set<EquipmentStorage> getAll() {
        return equipmentStorageDS;
    }
}//end
