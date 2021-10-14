//package za.ac.cput.repository.equipment;
//
//import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.Order;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;
//import za.ac.cput.entity.Equipment;
//import za.ac.cput.factory.EquipmentFactory;
//
//import static org.junit.jupiter.api.Assertions.*;
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//
//class EquipmentRepositoryTest {
//
//    private static EquipmentRepository repo = EquipmentRepository.getRepository();
//    private static Equipment equipment =
//            EquipmentFactory.createEquipment("Camera","Cimena Camera",
//                    "2015","Panasonic Lumix BGH1","Gauteng",200.99,true);
//    @Test
//    @Order(1)
//    void create() {
//        Equipment create = repo.create(equipment);
//        assertEquals(create.getEquipmentID(),equipment.getEquipmentID());
//        System.out.println("Equipment successfully created : " + create);
//
//    }
//
//    @Test
//    @Order(2)
//    void read()
//    {
//        Equipment readID = repo.read(equipment.getEquipmentID());
//        assertNotNull(readID);
//        System.out.println("ID read : " + readID);
//
//    }
//
//    @Test
//    @Order(3)
//    void update() {
//        Equipment updateEquipment = new Equipment.Builder().copy(equipment).
//                setGearSubCategory("Cinema Disco Lights").build();
//        assertNotNull(repo.update(updateEquipment));
//    }
//
//    @Test
//    @Order(4)
//    void delete() {
//        boolean deleted = repo.delete(equipment.getEquipmentID());
//       assertTrue(deleted);
//        System.out.println("ID doesn't exist : " + deleted);
//    }
//
//    @Test
//    @Order(5)
//    void getAll() {
//        System.out.println("Equipments Displayed : " +repo.getAll());
//    }
//}