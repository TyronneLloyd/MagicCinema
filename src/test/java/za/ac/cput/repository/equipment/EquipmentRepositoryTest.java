/* package za.ac.cput.repository.equipment;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.catalog.Equipment;
import za.ac.cput.factory.EquipmentFactory;

import javax.persistence.EntityNotFoundException;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class EquipmentRepositoryTest {

    private static EquipmentRepository repo;
    private static Equipment equipment =
            EquipmentFactory.createEquipment("CAM12","Camera","Cimena Camera",
                    "2015","Panasonic Lumix BGH1","Gauteng",3,200.99);
    @Test
    @Order(1)
    void create() {
        Equipment create = repo.save(equipment);
        assertEquals(create.getEquipmentID(),equipment.getEquipmentID());
        System.out.println("Equipment successfully created : " + create);

    }

    @Test
    @Order(2)
    void read()
    {
        Equipment readID = repo.findById(equipment.getEquipmentID()).orElseThrow(() -> new EntityNotFoundException());
        assertNotNull(readID);
        System.out.println("ID read : " + readID);

    }

    @Test
    @Order(3)
    void update() {
        Equipment updateEquipment = new Equipment.Builder().copy(equipment).
                setGearSubCategory("Cinema Disco Lights").build();
        assertNotNull(repo.save(updateEquipment));
    }

    @Test
    @Order(4)
    void delete() {
        int totalData = repo.getAll().size();
        repo.delete(equipment);
        assertEquals(repo.getAll().size(), totalData -1);
        System.out.println("Delete Successful");
    }

    @Test
    @Order(5)
    void getAll() {
        System.out.println("Equipments Displayed : " +repo.getAll());
    }
}

 */