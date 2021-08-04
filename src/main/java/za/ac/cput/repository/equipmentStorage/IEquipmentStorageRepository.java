package za.ac.cput.repository.equipmentStorage;
import za.ac.cput.entity.EquipmentStorage;
import za.ac.cput.repository.IRepository;
import java.util.List;
/*
    @Description:Repository ->
    @Author: Tyronne Lloyd Hendricks
    @Student Number: 215141210
    @Date: 03 August 2021
*/
public interface IEquipmentStorageRepository extends IRepository<EquipmentStorage, String> {
    List<EquipmentStorage> getAll();
}
