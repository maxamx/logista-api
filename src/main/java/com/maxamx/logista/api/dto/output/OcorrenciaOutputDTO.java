package com.maxamx.logista.api.dto.output;

import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
public class OcorrenciaOutputDTO {

    private Long id;
    private String descricao;
    private OffsetDateTime dataRegistro;
}
