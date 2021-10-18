package za.ac.cput.services.equipmentRental;

import za.ac.cput.entity.rent.EquipmentRental;
import za.ac.cput.entity.rent.RentItems;
import za.ac.cput.services.IService;

import java.util.List;
import java.util.Set;

public interface IRentItemsService extends IService<RentItems, Integer> {
    Set<RentItems> getAll();
    Set<RentItems> getRentalsFromCustomerId(String customerId);
}
