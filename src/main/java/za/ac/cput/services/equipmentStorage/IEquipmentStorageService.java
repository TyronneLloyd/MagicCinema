package za.ac.cput.services.equipmentStorage;
/*
    @Description:Repository ->
    @Author: Tyronne Lloyd Hendricks
    @Student Number: 215141210
    @Date: 03 August 2021
*/
import za.ac.cput.entity.EquipmentStorage;
import za.ac.cput.services.IService;
import java.util.Set;

public interface IEquipmentStorageService extends IService<EquipmentStorage, String> {
    Set<EquipmentStorage> getAll();
}
