package za.ac.cput.repository.equipment;

import za.ac.cput.entity.Equipment;
import za.ac.cput.entity.EquipmentStorage;
import za.ac.cput.repository.equipmentStorage.EquipmentStorageRepository;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class EquipmentRepository implements IEquipmentRepository {
    private static EquipmentRepository repo = null;
    private Set<Equipment> equipmentDB = null;

    private EquipmentRepository() {
        equipmentDB = new HashSet<Equipment>();
    }


   public static EquipmentRepository getRepository()
   {
       if(repo == null)
       {
           repo = new EquipmentRepository();
       }
       return repo;

   }
    @Override
    public Equipment create(Equipment equipment) {
        boolean success = equipmentDB.add(equipment);
        if(!success)
            return null;
        return equipment;
    }

    @Override
    public Equipment read(String equipmentID) {
        for (Equipment e : equipmentDB) {
            if (e.getEquipmentID().equalsIgnoreCase(equipmentID)) {
                return e;
            }
        }
        return null;
    }

    @Override
    public Equipment update(Equipment equipment) {
        Equipment oldEquipment = read(equipment.getEquipmentID());
        if(oldEquipment != null){
            equipmentDB.remove(oldEquipment);
            equipmentDB.add(equipment);
            return equipment;
        }
        return null;
    }

    @Override
    public boolean delete(String equipmentID) {
        Equipment equipmentDeleted  = read(equipmentID);
        if(equipmentDeleted == null)
            return false;
        equipmentDB.remove(equipmentDeleted);
        return true;
    }

    @Override
    public List<Equipment> getAll() {
        return null;
    }
}
