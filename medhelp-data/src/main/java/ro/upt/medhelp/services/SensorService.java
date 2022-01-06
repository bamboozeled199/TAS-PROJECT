package ro.upt.medhelp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.upt.medhelp.dao.PatientDAO;
import ro.upt.medhelp.dao.SensorDAO;
import ro.upt.medhelp.dao.UserDAO;
import ro.upt.medhelp.model.Sensor;
import ro.upt.medhelp.repositories.SensorRepository;
import ro.upt.medhelp.repositories.UserRepository;

@Service
public class SensorService {

    private SensorRepository sensorRepository;
    private UserService userService;
    private UserRepository userRepository;

    @Autowired
    public SensorService(SensorRepository sensorRepository, UserService userService, UserRepository userRepository) {
        this.sensorRepository = sensorRepository;
        this.userService = userService;
        this.userRepository = userRepository;
    }

    public Sensor addData(Long userId, Sensor sensor) {
        UserDAO existingUser = userRepository.findById(userId).orElse(null);
        if (existingUser != null) {
            PatientDAO existingPatient = existingUser.getPatient();
            if (existingPatient != null) {
                SensorDAO newSensor = new SensorDAO(sensor);
                newSensor.setPatient(existingPatient);
                existingPatient.addSensor(newSensor);
                userRepository.save(existingUser);
            }
            return null;
        }
        return null;
    }

    public Sensor findValue(String date) {
        return null;
    }

    public void deleteSensorData(String date) {

    }

    public Sensor updateSensorData(String date, Sensor sensor) {
        return null;
    }

}
