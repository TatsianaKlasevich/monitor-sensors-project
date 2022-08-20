package com.klasevich.monitorsensors.controller.dto;

import com.klasevich.monitorsensors.model.Range;
import com.klasevich.monitorsensors.model.Type;
import com.klasevich.monitorsensors.model.Unit;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class SensorResponseDto {

    private Long id;

    private String title;

    private String model;

    private Range range;

    private Type type;

    private Unit unit;

    private String location;

    private String description;
}
