package za.ac.cput.repository.equipment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.entity.catalog.Equipment;
import za.ac.cput.repository.IRepository;

import java.util.List;

@Repository
public interface EquipmentRepository extends JpaRepository<Equipment,String>
{
}
