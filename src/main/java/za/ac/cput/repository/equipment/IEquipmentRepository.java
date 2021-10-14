package za.ac.cput.repository.equipment;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.entity.Equipment;
import za.ac.cput.repository.IRepository;

import java.util.List;

public interface IEquipmentRepository extends JpaRepository<Equipment,String>
{
    List<Equipment> getAll();
}
