package com.maxamx.logista.api.dto.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Setter
@Getter
public class EntregaInputDTO {
    @Valid
    @NotNull
    private ClienteInputDTO cliente;

    @Valid
    @NotNull
    private DestinatarioInputDTO destinatario;

    @NotNull
    private BigDecimal taxa;
}
