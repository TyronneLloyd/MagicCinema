package za.ac.cput.services;

import org.springframework.stereotype.Service;
import za.ac.cput.entity.Equipment;
//import za.ac.cput.repository.equipment.EquipmentRepository;
import za.ac.cput.repository.equipment.EquipmentRepository;
import za.ac.cput.services.equipment.IEquipmentService;

import java.util.Set;

@Service
public class EquipmentService implements IEquipmentService {

    private static  EquipmentService service = null;
    private EquipmentRepository repo = null;

    private EquipmentService(){this.repo = EquipmentRepository.getRepository();}

    public static EquipmentService getService() {
        if (service == null) {
            service = new EquipmentService();
        }
        return service;
    }
    @Override
    public Equipment create(Equipment equipment) {
        return this.repo.create(equipment);
    }

    @Override
    public Equipment read(String equipmentID) {
        return this.repo.read(equipmentID);
    }

    @Override
    public Equipment update(Equipment equipment) {
        return this.repo.update(equipment);
    }

    @Override
    public boolean delete(String equipmentID) {
        return this.repo.delete(equipmentID);
    }

    @Override
    public Set<Equipment> getAll() {
        return (Set<Equipment>) this.repo.getAll();
    }
}
