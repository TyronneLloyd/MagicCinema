package za.ac.cput.repository.equipmentStorage;
import za.ac.cput.entity.EquipmentStorage;
import za.ac.cput.repository.IRepository;
import java.util.Set;

public interface IEquipmentStorageRepository extends IRepository<EquipmentStorage, String> {
    Set<EquipmentStorage> getAll();
}
