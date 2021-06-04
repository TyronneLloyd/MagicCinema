package za.ac.cput.Entity;
/*
    @Description: CarRental.java -> Car Rental class facilitates the renting of cars and records them
    @Author: Grant Hendricks
    @Student Number: 215138848
    @Date: 3 June 2021
  */

public class EquipmentRental {

    private String rentalID, clientID, equipmentID, employeeNumber, rentalStartDate, rentalEndDate;

    private EquipmentRental(Builder builder){
        this.rentalID = builder.rentalID;
        this.clientID = builder.clientID;
        this.equipmentID = builder.equipmentID;
        this.employeeNumber = builder.employeeNumber;
        this.rentalStartDate = builder.rentalStartDate;
        this.rentalEndDate = builder.rentalEndDate;
    }

    public static class Builder{

        private String rentalID, clientID, equipmentID, employeeNumber, rentalStartDate, rentalEndDate;

        public Builder RentalID(String rentalID){
            this.rentalID = rentalID;
            return this;
        }

        public Builder ClientID(String clientID){
            this.clientID = clientID;
            return this;
        }

        public Builder EquipmentID(String equipmentID){
            this.equipmentID = equipmentID;
            return this;
        }

        public Builder EmployeeNumber(String employeeNumber){
            this.employeeNumber = employeeNumber;
            return this;
        }

        public Builder RentalStartDate(String rentalStartDate){
            this.rentalStartDate = rentalStartDate;
            return this;
        }

        public Builder RentalEndDate(String rentalEndDate){
            this.rentalEndDate = rentalEndDate;
            return this;
        }

        public EquipmentRental build(){return new EquipmentRental(this);}

        public Builder copy(EquipmentRental EquipmentRental){
            this.rentalID = EquipmentRental.rentalID;
            this.clientID = EquipmentRental.clientID;
            this.equipmentID = EquipmentRental.equipmentID;
            this.employeeNumber = EquipmentRental.employeeNumber;
            this.rentalStartDate = EquipmentRental.rentalStartDate;
            this.rentalEndDate = EquipmentRental.rentalEndDate;
            return this;
        }

    }    //Builder class ends

    @Override
    public String toString() {
        return "EquipmentRental{" +
                "rentalID='" + rentalID + '\'' +
                ", clientID='" + clientID + '\'' +
                ", equipmentID='" + equipmentID + '\'' +
                ", employeeNumber='" + employeeNumber + '\'' +
                ", rentalStartDate='" + rentalStartDate + '\'' +
                ", rentalEndDate='" + rentalEndDate + '\'' +
                '}';
    }

    public String getRentalID() {
        return rentalID;
    }

    public String getClientID() {
        return clientID;
    }

    public String getEquipmentID() {
        return equipmentID;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public String getRentalStartDate() {
        return rentalStartDate;
    }

    public String getRentalEndDate() {
        return rentalEndDate;
    }
}
