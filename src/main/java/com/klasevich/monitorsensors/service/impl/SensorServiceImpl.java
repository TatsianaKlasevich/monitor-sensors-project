package com.klasevich.monitorsensors.service.impl;

import com.klasevich.monitorsensors.exception.SensorNotFoundException;
import com.klasevich.monitorsensors.model.Sensor;
import com.klasevich.monitorsensors.repository.SensorRepository;
import com.klasevich.monitorsensors.service.SensorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SensorServiceImpl implements SensorService {

    private static final String SENSOR_NOT_FOUND_EXCEPTION_MESSAGE = "Unable to find sensor with id: %d";
    private final SensorRepository sensorRepository;

    @Override
    @Transactional(readOnly = true)
    public Sensor findSensorById(Long sensorId) {
        return sensorRepository.findById(sensorId)
                .orElseThrow(() -> new SensorNotFoundException(String.format(SENSOR_NOT_FOUND_EXCEPTION_MESSAGE, sensorId)));
    }

    @Override
    @Transactional
    public Sensor addSensor(Sensor sensor) {
        return sensorRepository.save(sensor);
    }

    @Override
    @Transactional
    public Sensor deleteSensor(Long id) {
        Sensor deletedSensor = findSensorById(id);
        sensorRepository.deleteById(id);
        return deletedSensor;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Sensor> findAllSensors() {
        return sensorRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Sensor> findAllSensorsByData(String data) {
        System.out.println(data);
        return sensorRepository.findAllSensorsByData(data);
    }
}
