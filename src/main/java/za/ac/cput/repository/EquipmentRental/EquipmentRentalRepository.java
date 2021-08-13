package za.ac.cput.repository.EquipmentRental;
/*
    @Description: EquipmentRentalRepository class
    @Author: Grant Hendricks
    @Student Number: 215138848
    @Date: 5 August 2021
  */

import za.ac.cput.entity.EquipmentRental;
import java.util.HashSet;
import java.util.Set;

public class EquipmentRentalRepository implements IEquipmentRentalRepository {
    private static EquipmentRentalRepository repository = null;
    private Set<EquipmentRental> equipmentRentalDB = null;

    private EquipmentRentalRepository(){
        equipmentRentalDB = new HashSet<EquipmentRental>();
    }

    public static  EquipmentRentalRepository getRepository(){
        if(repository == null){
            repository = new EquipmentRentalRepository();
        }
        return  repository;
    }

    @Override
    public EquipmentRental create(EquipmentRental rental){
        boolean success = equipmentRentalDB.add(rental);
        if(!success)
            return null;
        return rental;
    }

    @Override
    public EquipmentRental read(String rentalID) {
        for (EquipmentRental es : equipmentRentalDB) {
            if (es.getRentalID().equalsIgnoreCase(rentalID)) {
                return es;
            }
        }
        return null;
    }

    @Override
    public EquipmentRental update(EquipmentRental rental) {
        EquipmentRental oldER = read(rental.getRentalID());
        if(oldER != null){
            equipmentRentalDB.remove(oldER);
            equipmentRentalDB.add(rental);
            return rental;
        }
        return null;
    }

    @Override
    public boolean delete(String rentalID) {
        EquipmentRental equipmentRentalRemoved  = read(rentalID);
        if(equipmentRentalRemoved == null)
            return false;
        equipmentRentalDB.remove(equipmentRentalRemoved);
        return true;
    }


    @Override
    public Set<EquipmentRental> getAll() {
        return equipmentRentalDB;
    }
}//end

