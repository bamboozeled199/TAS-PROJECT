package ro.upt.medhelp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ro.upt.medhelp.model.Sensor;
import ro.upt.medhelp.services.SensorService;

@RestController
@RequestMapping(value = "/sensors")
public class SensorController {

    private SensorService sensorService;

    @Autowired
    public SensorController(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    @PostMapping(path = "/{userId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Sensor addSensorValue(@PathVariable Long userId, @RequestBody Sensor sensor) {
        if (sensor == null) {
            return null;
        } else {
            return sensorService.addData(userId, sensor);
        }
    }

    @GetMapping(path = "/{date}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Sensor findSensorValue(@PathVariable("date") String date) {
        if (date == null) {
            return null;
        } else {
            return sensorService.findValue(date);
        }
    }

    @DeleteMapping(path = "/{date}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteSensorValue(@PathVariable("date") String date) {
        if (date != null) {
            sensorService.deleteSensorData(date);
        }
    }

    @PutMapping(path = "/{date}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Sensor updateSensorValue(@PathVariable("date") String date, @RequestBody Sensor sensor) {
        if (date != null && sensor != null) {
            return sensorService.updateSensorData(date, sensor);
        }
        return null;
    }


}
