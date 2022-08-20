package com.klasevich.monitorsensors.mapper;

import com.klasevich.monitorsensors.controller.dto.SensorResponseDto;
import com.klasevich.monitorsensors.model.Sensor;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface SensorToSensorResponseDtoMapper extends Converter<Sensor, SensorResponseDto> {

    @Override
    SensorResponseDto convert(Sensor sensor);
}
