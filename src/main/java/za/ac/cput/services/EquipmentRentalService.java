package za.ac.cput.services;
/*
    @Description: EquipmentRentalService class
    @Author: Grant Hendricks
    @Student Number: 215138848
    @Date: 5 August 2021
  */

import org.springframework.stereotype.Service;
import za.ac.cput.entity.EquipmentRental;
import za.ac.cput.repository.EquipmentRental.EquipmentRentalRepository;
import za.ac.cput.services.equipmentRental.IEquipmentRentalService;

import java.util.Set;
@Service
public class EquipmentRentalService implements IEquipmentRentalService {

    private static EquipmentRentalService service = null;
    private EquipmentRentalRepository repository = null;

    private EquipmentRentalService(){
        this.repository = EquipmentRentalRepository.getRepository();
    }

    public static EquipmentRentalService getService() {
        if (service == null){
            service = new EquipmentRentalService();
        }
        return service;
    }

    @Override
    public EquipmentRental create(EquipmentRental t) {
        return this.repository.create(t);
    }

    @Override
    public EquipmentRental read(String rentalID) {
        return this.repository.read(rentalID);
    }

    @Override
    public EquipmentRental update(EquipmentRental t) {
        return this.repository.update(t);
    }

    @Override
    public boolean delete(String rentalID) {
        return this.repository.delete(rentalID);
    }

    @Override
    public Set<EquipmentRental> getAll() {
        return (Set<EquipmentRental>) this.repository.getAll();
    }

}
