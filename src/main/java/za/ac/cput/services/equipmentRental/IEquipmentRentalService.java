package za.ac.cput.services.equipmentRental;

import za.ac.cput.entity.EquipmentRental;
import za.ac.cput.services.IService;
import java.util.Set;

public interface IEquipmentRentalService  extends IService<EquipmentRental,String> {
    Set<EquipmentRental> getAll();
}
