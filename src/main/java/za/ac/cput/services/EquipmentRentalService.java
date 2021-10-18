package za.ac.cput.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.rent.EquipmentRental;
import za.ac.cput.repository.EquipmentRental.EquipmentRentalRepository;
import za.ac.cput.services.equipmentRental.IEquipmentRentalService;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class EquipmentRentalService implements IEquipmentRentalService {

    private EquipmentRentalRepository repository;

    @Autowired
    private EquipmentRentalService(EquipmentRentalRepository repository){
        this.repository = repository;
    }

    @Override
    public EquipmentRental create(EquipmentRental equipmentRental) {
        System.out.println(equipmentRental);
        return this.repository.save(equipmentRental);
    }

    @Override
    public EquipmentRental read(String rentalID) {
        return this.repository.findById(rentalID).orElseThrow(() -> new EntityNotFoundException("Equipment with id " + rentalID + " was not found" ));
    }

    @Override
    public EquipmentRental update(EquipmentRental equipmentRental) {
        if(this.repository.existsById(equipmentRental.getEquipmentID()))
            return this.repository.save(equipmentRental);
        return null;
    }

    @Override
    public boolean delete(String rentalID) {
        this.repository.deleteById(rentalID);
        if(this.repository.existsById(rentalID))
            return false;
        else
            return true;
    }

    @Override
    public List<EquipmentRental> getAll() {
        return this.repository.findAll(Sort.by(Sort.Direction.ASC, "rentalID"));
    }

    @Override
    public List<EquipmentRental> getRentalsFromCustomerId(String customerId) {
        List<EquipmentRental> allRentals = getAll();
        List<EquipmentRental> output = new ArrayList<>();

        for(EquipmentRental rental: allRentals) {
            if(rental.getClientID().equals(customerId) && rental.getRentalEndDate().equals("")) {
                output.add(rental);
            }
        }

        return output;
    }

}
