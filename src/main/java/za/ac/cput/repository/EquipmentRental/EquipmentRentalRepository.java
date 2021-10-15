package za.ac.cput.repository.EquipmentRental;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.entity.rent.EquipmentRental;

@Repository
public interface EquipmentRentalRepository extends JpaRepository<EquipmentRental, String> {
}

