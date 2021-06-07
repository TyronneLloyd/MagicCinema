package za.ac.cput.Entity;
/*  @Subject: Project 3
    @Description: EquipmentStorage Entity -> EquipmentStorage.java
    @Author: Rick Allen Herbert
    @Student Number: 219014337
    @Date: 06/07/2021
  */
public class EquipmentStorage {

    private String shelfSpace;
    private String equipmentID;

    private EquipmentStorage(Builder builder) {
        this.shelfSpace = builder.shelfSpace;
        this.equipmentID = builder.equipmentID;
    }
    public static class Builder {
        private String shelfSpace;
        private String equipmentID;

        public Builder ShelfSpace(String shelfSpace) {
            this.shelfSpace = shelfSpace;
            return this;
        }

        public Builder EquipmentID(String equipmentID) {
            this.equipmentID = equipmentID;
            return this;
        }

        public EquipmentStorage build() {
            return new EquipmentStorage(this);
        }

        private Builder copy(EquipmentStorage equipmentStorage) {
            this.shelfSpace = equipmentStorage.shelfSpace;
            this.equipmentID = equipmentStorage.equipmentID;
            return this;
        }
    }
}
