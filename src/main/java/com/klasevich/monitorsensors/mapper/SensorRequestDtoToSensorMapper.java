package com.klasevich.monitorsensors.mapper;

import com.klasevich.monitorsensors.controller.dto.SensorRequestDto;
import com.klasevich.monitorsensors.model.Sensor;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface SensorRequestDtoToSensorMapper extends Converter<SensorRequestDto, Sensor> {

    @Override
    Sensor convert(SensorRequestDto sensorRequestDto);
}


