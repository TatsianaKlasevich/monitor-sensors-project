package com.klasevich.monitorsensors.controller.dto;

import com.klasevich.monitorsensors.controller.dto.validator.ValidRange;
import com.klasevich.monitorsensors.model.Type;
import com.klasevich.monitorsensors.model.Unit;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Builder
public class SensorRequestDto {

    @NotNull
    @Size(max = 30)
    private String title;

    @NotNull
    @Size(max = 15)
    private String model;

    @Valid
    private Range range;

    @NotNull
    private Type type;

    private Unit unit;

    @Size(max = 40)
    private String location;

    @Size(max = 200)
    private String description;

    @Getter
    @Setter
    @ValidRange.List({
            @ValidRange(
                    from = "from",
                    to = "to"
            )
    })
    public static class Range {

        @NotNull
        private Integer from;

        @NotNull
        private Integer to;
    }
}
