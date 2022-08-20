package com.klasevich.monitorsensors.service;

import com.klasevich.monitorsensors.model.Sensor;

import java.util.List;

public interface SensorService {
    Sensor findSensorById(Long sensorId);

    Sensor addSensor(Sensor sensor);

    Sensor deleteSensor(Long id);

    List<Sensor> findAllSensors();

    List<Sensor> findAllSensorsByData(String data);
}


