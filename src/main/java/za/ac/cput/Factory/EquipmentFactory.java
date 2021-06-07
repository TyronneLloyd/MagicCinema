package za.ac.cput.Factory;
/*  @Subject: Project 3
    @Description: Equipment Factory
    @Author: Asiphiwe Hanjiwe
    @Student Number: 218336675
    @Date: 07 June 2021
  */
import za.ac.cput.Entity.Equipment;
import za.ac.cput.Util.GenericHelper;

public class EquipmentFactory
{
    public static Equipment createEquipment (String gearCategory,String gearSubCategory,String make, String model,String location, double rentalprice,boolean rented) {
        String equipmentID = GenericHelper.generateId();

        Equipment equipment = new Equipment.Builder()
                .setEquipmentID(equipmentID)
                .setGearCategory(gearCategory)
                .setGearSubCategory(gearSubCategory)
                .setMake(make)
                .setModel(model)
                .setLocation(location)
                .setRentalprice(rentalprice)
                .setRented(rented)
                .build();

                return equipment;
    }
}
