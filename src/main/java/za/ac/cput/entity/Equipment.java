package za.ac.cput.entity;
/*  @Subject: Project 3
    @Description: Equipment Entity -> Employee.java
    @Author: Asiphiwe Hanjiwe
    @Student Number: 218336675
    @Date: 07 June 2021
  */
public class Equipment {
    private String equipmentID,gearCategory,gearSubCategory,make,model,location;
    private double rentalprice;
    private boolean available;
    private int quantity; // needs to be added

    private Equipment (Builder builder)
    {
        this.equipmentID = builder.equipmentID;
        this.gearCategory = builder.gearCategory;
        this.gearSubCategory =builder.gearSubCategory;
        this.make = builder.make;
        this.model = builder.model;
        this.location = builder.location;
        this.rentalprice = builder.rentalprice;
        this.available = builder.available;
    }

    public String getEquipmentID() {
        return equipmentID;
    }

    public String getGearCategory() {
        return gearCategory;
    }

    public String getGearSubCategory() {
        return gearSubCategory;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getLocation() {
        return location;
    }

    public double getRentalprice() {
        return rentalprice;
    }

    public boolean isRented() {
        return available;
    }
    public static class Builder
    {
        private String equipmentID,gearCategory,gearSubCategory,make,model,location;
        private double rentalprice;
        private boolean available;


        public Builder setEquipmentID(String equipmentID) {
            this.equipmentID = equipmentID;
            return this;
        }

        public Builder setGearCategory(String gearCategory) {
            this.gearCategory = gearCategory;
            return this;

        }

        public Builder setGearSubCategory(String gearSubCategory) {
            this.gearSubCategory = gearSubCategory;
            return this;
        }

        public Builder setMake(String make) {
            this.make = make;
            return this;
        }

        public Builder setModel(String model) {
            this.model = model;
            return this;
        }

        public Builder setLocation(String location) {
            this.location = location;
            return this;
        }

        public Builder setRentalprice(double rentalprice) {
            this.rentalprice = rentalprice;
            return this;
        }

        public Builder setRented(boolean rented) {
            this.available = rented;
            return this;
        }

        public Equipment build()
        {
            return new Equipment(this);
        }

        public Builder copy(Equipment equipment)
        {
            this.equipmentID = equipment.equipmentID;
            this.gearCategory = equipment.gearCategory;
            this.gearSubCategory = equipment.gearSubCategory;
            this.make = equipment.make;
            this.model = equipment.model;
            this.location = equipment.location;
            this.rentalprice = equipment.rentalprice;
            this.available = equipment.available;
            return this;
        }
    }
    @Override
    public String toString() {
        return "Equipment{" +
                "equipmentID='" + equipmentID + '\'' +
                ", gearCategory='" + gearCategory + '\'' +
                ", gearSubCategory='" + gearSubCategory + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", location='" + location + '\'' +
                ", rentalprice=" + rentalprice +
                ", rented=" + available +
                '}';
    }
}
