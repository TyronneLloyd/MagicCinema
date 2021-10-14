package za.ac.cput.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.catalog.EquipmentCategory;
import za.ac.cput.repository.equipment.EquipmentCategoryRepository;
import za.ac.cput.services.equipment.IEquipmentCategoryService;

import javax.persistence.EntityNotFoundException;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EquipmentCategoryService implements IEquipmentCategoryService {

    private EquipmentCategoryRepository repository;

    @Autowired
    private EquipmentCategoryService(EquipmentCategoryRepository repository){
        this.repository = repository;
    }

    @Override
    public EquipmentCategory create(EquipmentCategory equipmentCategory) {
        return this.repository.save(equipmentCategory);
    }

    @Override
    public EquipmentCategory read(String equipmentCategoryId) {
        return this.repository.findById(equipmentCategoryId).orElseThrow(() -> new EntityNotFoundException("Equipment Category with id " + equipmentCategoryId + " was not found" ));
    }

    @Override
    public EquipmentCategory update(EquipmentCategory equipmentCategory) {
        if(this.repository.existsById(equipmentCategory.getGearCategoryID()))
            return this.repository.save(equipmentCategory);
        return null;
    }

    @Override
    public boolean delete(String equipmentCategoryId) {
        this.repository.deleteById(equipmentCategoryId);
        if(this.repository.existsById(equipmentCategoryId))
            return false;
        else
            return true;
    }

    @Override
    public Set<EquipmentCategory> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public String getEquipmentIdByCategory(String category) {
        Set<EquipmentCategory> allEquipmentCategory = getAll();
        for(EquipmentCategory equipmentCategory : allEquipmentCategory) {
            if(equipmentCategory.getGearCategoryTitle().equals(category)) {
                return equipmentCategory.getGearCategoryID();
            }
        }
        return "not_found";
    }
}
