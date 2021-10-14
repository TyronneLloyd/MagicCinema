package za.ac.cput.services.equipment;

import za.ac.cput.entity.catalog.Equipment;
import za.ac.cput.entity.catalog.EquipmentCategory;
import za.ac.cput.services.IService;

import java.util.Set;

public interface IEquipmentCategoryService extends IService<EquipmentCategory, String> {
    Set<EquipmentCategory> getAll();
    String getEquipmentIdByCategory(String category);
}
