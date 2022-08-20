package com.klasevich.monitorsensors.controller;

import com.klasevich.monitorsensors.controller.dto.SensorRequestDto;
import com.klasevich.monitorsensors.controller.dto.SensorResponseDto;
import com.klasevich.monitorsensors.mapper.SensorRequestDtoToSensorMapper;
import com.klasevich.monitorsensors.mapper.SensorToSensorResponseDtoMapper;
import com.klasevich.monitorsensors.model.Sensor;
import com.klasevich.monitorsensors.service.SensorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.List;
import java.util.stream.Collectors;


@Api("Sensor controller")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/sensors")
public class SensorController {

    private final SensorService sensorService;
    private final SensorToSensorResponseDtoMapper sensorToSensorResponseDtoMapper;
    private final SensorRequestDtoToSensorMapper sensorRequestDtoToSensorMapper;

    @ApiOperation(value = "Find sensor by id",
            authorizations = {@Authorization(value = "basicAuth")})

    @GetMapping("/{id}")
    public SensorResponseDto findSensor(@PathVariable Long id) {
        return sensorToSensorResponseDtoMapper.convert(sensorService.findSensorById(id));
    }

    @ApiOperation(value = "Get all sensors",
            authorizations = {@Authorization(value = "basicAuth")})
    @GetMapping
    public List<SensorResponseDto> findAllSensors() {
        return sensorService.findAllSensors().stream()
                .map(sensorToSensorResponseDtoMapper::convert)
                .collect(Collectors.toList());
    }

    @ApiOperation(value = "Add sensor",
            authorizations = {@Authorization(value = "basicAuth")})
    @PostMapping
    public SensorResponseDto addSensor(@RequestBody @Valid SensorRequestDto sensorRequestDto) {
        Sensor sensor = sensorRequestDtoToSensorMapper.convert(sensorRequestDto);
        return sensorToSensorResponseDtoMapper.convert(sensorService.addSensor(sensor));
    }

    @ApiOperation(value = "Update sensor",
            authorizations = {@Authorization(value = "basicAuth")})
    @PutMapping("/{id}")
    public SensorResponseDto updateSensor(@PathVariable Long id,
                                          @RequestBody @Valid SensorRequestDto sensorRequestDto) {
        Sensor sensor = sensorRequestDtoToSensorMapper.convert(sensorRequestDto);
        sensor.setId(id);
        return sensorToSensorResponseDtoMapper.convert(sensorService.addSensor(sensor));
    }

    @ApiOperation(value = "Delete sensor",
            authorizations = {@Authorization(value = "basicAuth")})
    @DeleteMapping("/{id}")
    public SensorResponseDto deleteUser(@PathVariable Long id) {
        return sensorToSensorResponseDtoMapper.convert(sensorService.deleteSensor(id));
    }

    @ApiOperation(value = "Searching sensors by some data of Title and Model",
            authorizations = {@Authorization(value = "basicAuth")})
    @GetMapping("/data")
    public List<SensorResponseDto> findAllSensorsByData(@PathParam("data") String data) {
        return sensorService.findAllSensorsByData(data).stream()
                .map(sensorToSensorResponseDtoMapper::convert)
                .collect(Collectors.toList());
    }
}