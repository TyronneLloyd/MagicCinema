package za.ac.cput.services.equipmentRental;

import za.ac.cput.entity.rent.EquipmentRental;
import za.ac.cput.services.IService;

import java.util.List;

public interface IEquipmentRentalService  extends IService<EquipmentRental,String> {
    List<EquipmentRental> getAll();
    List<EquipmentRental> getRentalsFromCustomerId(String customerId);
}
