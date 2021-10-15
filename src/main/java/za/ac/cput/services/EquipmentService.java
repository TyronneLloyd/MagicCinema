package za.ac.cput.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.catalog.Equipment;
import za.ac.cput.repository.equipment.EquipmentRepository;
import za.ac.cput.services.equipment.IEquipmentService;

import javax.persistence.EntityNotFoundException;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EquipmentService implements IEquipmentService {

    private EquipmentRepository repository;

    @Autowired
    private EquipmentService(EquipmentRepository repository){
        this.repository = repository;
    }

    @Override
    public Equipment create(Equipment equipment) {
        return this.repository.save(equipment);
    }

    @Override
    public Equipment read(String equipmentID) {
        return this.repository.findById(equipmentID).orElseThrow(() -> new EntityNotFoundException("Equipment with id " + equipmentID + " was not found" ));
    }

    @Override
    public Equipment update(Equipment equipment) {
        if(this.repository.existsById(equipment.getEquipmentID()))
            return this.repository.save(equipment);
        return null;
    }

    @Override
    public boolean delete(String equipmentID) {
        this.repository.deleteById(equipmentID);
        if(this.repository.existsById(equipmentID))
            return false;
        else
            return true;
    }

    @Override
    public Set<Equipment> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public Set<Equipment> getAllValidEquipment() {
        Set<Equipment> allEquipment = getAll();
        Set<Equipment> validEquipment = new HashSet<>();
        for(Equipment equipment : allEquipment) {
            if(equipment.isAvailable()) {
                validEquipment.add(equipment);
            }
        }
        return validEquipment;
    }
}
