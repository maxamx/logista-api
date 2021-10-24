package com.maxamx.logista.api.dto.output;

import com.maxamx.logista.domain.model.StatusEntrega;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
public class EntregaOutputDTO {
    private Long id;
    private ClienteOutputDTO cliente;
    private BigDecimal taxa;
    private StatusEntrega status;
    private OffsetDateTime dataPedido;
    private OffsetDateTime dataFinalizacao;
    private DestinatarioOutputDTO destinatario;
}
