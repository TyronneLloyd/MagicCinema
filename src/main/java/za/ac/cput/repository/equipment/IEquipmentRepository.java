package za.ac.cput.repository.equipment;

import za.ac.cput.entity.Equipment;
import za.ac.cput.repository.IRepository;

import java.util.List;

public interface IEquipmentRepository extends IRepository<Equipment,String>
{
    List<Equipment> getAll();
}
