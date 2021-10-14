package za.ac.cput.repository.equipment;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.entity.catalog.EquipmentCategory;

public interface EquipmentCategoryRepository extends JpaRepository<EquipmentCategory, String> {
}
