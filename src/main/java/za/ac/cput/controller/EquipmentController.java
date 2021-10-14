package za.ac.cput.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.catalog.Equipment;
import za.ac.cput.entity.catalog.EquipmentCategory;
import za.ac.cput.factory.EquipmentFactory;
import za.ac.cput.services.EquipmentCategoryService;
import za.ac.cput.services.EquipmentService;
import za.ac.cput.services.equipment.IEquipmentCategoryService;

import java.util.HashSet;
import java.util.Set;
@RestController
@RequestMapping("/equipment")
public class EquipmentController {

    @Autowired
    private EquipmentService equipmentService;

    @Autowired
    private EquipmentCategoryService equipmentCategoryService;

    @PostMapping(value = "/create")
    public Equipment create(@RequestBody Equipment equipment) {
        return equipmentService.create(equipment);
    }
    @GetMapping("/read")
    public Equipment read (@RequestBody Equipment equipment)
    {
        return equipmentService.read(equipment.getEquipmentID());
    }
    @PostMapping("/update")
    public Equipment update (@RequestBody Equipment equipment)
    {
        return equipmentService.update(equipment);
    }
    @DeleteMapping("/delete/{equipmentID}")
    public boolean delete(@PathVariable String equipmentID)
    {
        return equipmentService.delete(equipmentID);
    }
    @GetMapping("/getAllEquipmentRented")
    public Set<Equipment>getAll()
    {
        return equipmentService.getAll();
    }
    @GetMapping("/getAllValidEquipment")
    public Set<Equipment> getAllValidEquipment() {
        return equipmentService.getAllValidEquipment();
    }
    @GetMapping("/getEquipmentCategories")
    public Set<EquipmentCategory> getEquipmentCategories() {
        return equipmentCategoryService.getAll();
    }
    @GetMapping("/getAllEquipmentByCategory/{category}")
    public Set<Equipment> getAllEquipmentByCategory(@PathVariable String category) {
        Set<Equipment> allEquipments = getAllValidEquipment();
        Set<Equipment> output = new HashSet<>();

        String selectedCategory = equipmentCategoryService.getEquipmentIdByCategory(category);
        for(Equipment equipment: allEquipments) {
            if(equipment.getGearCategory().equals(selectedCategory)) {
                output.add(equipment);
            }
        }
        if(category.equals("clearFilters")) {
            return allEquipments;
        }
        return output;
    }

}
