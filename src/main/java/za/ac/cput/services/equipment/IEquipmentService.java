package za.ac.cput.services.equipment;

import za.ac.cput.entity.Equipment;
import za.ac.cput.services.IService;

import java.util.Set;

public interface IEquipmentService extends IService<Equipment,String>
{
    Set<Equipment> getAll();
}
