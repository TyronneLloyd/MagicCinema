package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.EquipmentStorageLog;
import za.ac.cput.factory.EquipmentStorageLogFactory;
import za.ac.cput.services.EquipmentStorageLogService;

import java.util.Set;

@RestController
@RequestMapping("/equipmentstoragelog")
public class EquipmentStorageLogController {

    @Autowired
    private EquipmentStorageLogService logService;

    @RequestMapping(value = "/create")
    public EquipmentStorageLog create(@RequestBody EquipmentStorageLog equipmentStorageLog) {
        EquipmentStorageLog newLog = EquipmentStorageLogFactory.createEquipmentStorageLog(
                equipmentStorageLog.getEquipmentStorageCategory(),
                equipmentStorageLog.getEquipmentStorageLocation()
        );
        return logService.create(newLog);
    }
    @GetMapping("/read/{equipmentStorageLogID}")
    public EquipmentStorageLog read(@PathVariable String equipmentStorageLogID) {
        return logService.read(equipmentStorageLogID);
    }

    @RequestMapping("/update")
    public EquipmentStorageLog update(@RequestBody EquipmentStorageLog equipmentStorageLog) {
        EquipmentStorageLog updateStorageLog = logService.update(equipmentStorageLog);
        return updateStorageLog;
    }

    @RequestMapping("/delete")
    public boolean delete(@RequestBody EquipmentStorageLog equipmentStorageLog) {
        if(logService.delete(equipmentStorageLog.getEquipmentStorageLogId()))
            return true;
        return false;
    }

    @RequestMapping("/getall")
    public Set<EquipmentStorageLog> getAll() {
        return logService.getAll();
    }
}
