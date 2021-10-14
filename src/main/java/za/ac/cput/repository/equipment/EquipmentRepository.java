package za.ac.cput.repository.equipment;


import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import za.ac.cput.entity.Equipment;
import za.ac.cput.entity.EquipmentStorage;
import za.ac.cput.repository.equipmentStorage.EquipmentStorageRepository;

import java.util.*;

public class EquipmentRepository implements IEquipmentRepository {
    private static EquipmentRepository repo = null;
    private Set<Equipment> equipmentDB = null;

    private EquipmentRepository() {
        equipmentDB = new HashSet<Equipment>();
    }


   public static EquipmentRepository getRepository()
   {
       if(repo == null)
       {
           repo = new EquipmentRepository();
       }
       return repo;

   }
   // @Override
    public Equipment create(Equipment equipment) {
        boolean success = equipmentDB.add(equipment);
        if(!success)
            return null;
        return equipment;
    }

   // @Override
    public Equipment read(String equipmentID) {
        for (Equipment e : equipmentDB) {
            if (e.getEquipmentID().equalsIgnoreCase(equipmentID)) {
                return e;
            }
        }
        return null;
    }

   // @Override
    public Equipment update(Equipment equipment) {
        Equipment oldEquipment = read(equipment.getEquipmentID());
        if(oldEquipment != null){
            equipmentDB.remove(oldEquipment);
            equipmentDB.add(equipment);
            return equipment;
        }
        return null;
    }

    //@Override
    public boolean delete(String equipmentID) {
        Equipment equipmentDeleted  = read(equipmentID);
        if(equipmentDeleted == null)
            return false;
        equipmentDB.remove(equipmentDeleted);
        return true;
    }

    @Override
    public List<Equipment> getAll() {
        return null;
    }

    @Override
    public List<Equipment> findAll() {
        return null;
    }

    @Override
    public List<Equipment> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Equipment> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Equipment> findAllById(Iterable<String> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(String s) {

    }

    @Override
    public void delete(Equipment equipment) {

    }

    @Override
    public void deleteAllById(Iterable<? extends String> iterable) {

    }

    @Override
    public void deleteAll(Iterable<? extends Equipment> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Equipment> S save(S s) {
        return null;
    }

    @Override
    public <S extends Equipment> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Equipment> findById(String s) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(String s) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Equipment> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public <S extends Equipment> List<S> saveAllAndFlush(Iterable<S> iterable) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Equipment> iterable) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<String> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Equipment getOne(String s) {
        return null;
    }

    @Override
    public Equipment getById(String s) {
        return null;
    }

    @Override
    public <S extends Equipment> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Equipment> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Equipment> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Equipment> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Equipment> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Equipment> boolean exists(Example<S> example) {
        return false;
    }
}
