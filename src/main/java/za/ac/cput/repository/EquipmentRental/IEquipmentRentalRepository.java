package za.ac.cput.repository.EquipmentRental;
/*
    @Description: EquipmentRentalRepository class
    @Author: Grant Hendricks
    @Student Number: 215138848
    @Date: 5 August 2021
  */

import za.ac.cput.entity.EquipmentRental;
import za.ac.cput.repository.IRepository;
import java.util.Set;

public interface IEquipmentRentalRepository extends IRepository<EquipmentRental, String> {
    Set<EquipmentRental> getAll();
}
