package com.maxamx.logista.api.dto.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
@Getter
@Setter
public class ClienteInputDTO {

    @NotNull
    private Long id;
}
