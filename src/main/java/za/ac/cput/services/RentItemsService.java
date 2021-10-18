package za.ac.cput.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.rent.RentItems;
import za.ac.cput.repository.EquipmentRental.RentItemsRepository;
import za.ac.cput.services.equipmentRental.IRentItemsService;

import javax.persistence.EntityNotFoundException;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RentItemsService implements IRentItemsService {

    private final RentItemsRepository repository;

    @Autowired
    RentItemsService(RentItemsRepository repository) {
        this.repository = repository;
    }

    @Override
    public RentItems create(RentItems rentItems) {

        return this.repository.save(rentItems);
    }

    @Override
    public RentItems read(Integer rentId) {
        return this.repository.findById(rentId).orElseThrow(() -> new EntityNotFoundException("Rent with id " + rentId + " was not found" ));
    }

    @Override
    public RentItems update(RentItems rentItems) {
        if(this.repository.existsById(rentItems.getId()))
            return this.repository.save(rentItems);
        return null;
    }

    @Override
    public boolean delete(Integer rentId) {
        this.repository.deleteById(rentId);
        if(this.repository.existsById(rentId))
            return false;
        else
            return true;
    }

    @Override
    public Set<RentItems> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public Set<RentItems> getRentalsFromCustomerId(String customerId) {
        Set<RentItems> rentals = getAll();
        Set<RentItems> returnValues = new HashSet<>();
        for(RentItems rent : rentals) {
            if(rent.getClient() == customerId) {
                returnValues.add(rent);
            }
        }
        return returnValues;
    }
}
