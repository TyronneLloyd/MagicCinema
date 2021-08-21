package za.ac.cput.entity;

public class EquipmentStorageLog {
    String equipmentStorageLogId, equipmentStorageCategory, equipmentStorageLocation;

    public EquipmentStorageLog() {};

    private EquipmentStorageLog(Builder builder) {
        this.equipmentStorageLogId = builder.equipmentStorageLogId;
        this.equipmentStorageCategory = builder.equipmentStorageCategory;
        this.equipmentStorageLocation = builder.equipmentStorageLocation;
    }
    @Override
    public String toString() {
        return "Equipment Storage: \nID: " + equipmentStorageLogId + "\nCategory: " + equipmentStorageCategory + "\n" +
                "Location: " + equipmentStorageLocation;

    }

    public static class Builder {
        private String equipmentStorageLogId, equipmentStorageCategory, equipmentStorageLocation;

        public Builder setEquipmentStorageLogId(String equipmentStorageLogId){
            this.equipmentStorageLogId = equipmentStorageLogId;
            return this;
        }

        public Builder setEquipmentStorageCategory(String equipmentStorageCategory){
            this.equipmentStorageCategory = equipmentStorageCategory;
            return this;
        }

        public Builder setEquipmentStorageLocation(String equipmentStorageLocation){
            this.equipmentStorageLocation = equipmentStorageLocation;
            return this;
        }

        public EquipmentStorageLog build() {
            return new EquipmentStorageLog(this);
        }

        public Builder copy(EquipmentStorageLog equipmentStorageLog) {
            this.equipmentStorageLogId = equipmentStorageLog.equipmentStorageLogId;
            this.equipmentStorageCategory = equipmentStorageLog.equipmentStorageCategory;
            this.equipmentStorageLocation = equipmentStorageLog.equipmentStorageLogId;
            return this;
        }
    }
    public String getEquipmentStorageLogId() {
        return equipmentStorageLogId;
    }
    public String getEquipmentStorageCategory() {
        return equipmentStorageCategory;
    }
    public String getEquipmentStorageLocation() {
        return equipmentStorageLocation;
    }
}
