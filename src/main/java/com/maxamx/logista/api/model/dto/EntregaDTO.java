package com.maxamx.logista.api.model.dto;

import com.maxamx.logista.api.model.dto.DestinatarioDTO;
import com.maxamx.logista.domain.model.Destinatario;
import com.maxamx.logista.domain.model.StatusEntrega;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
public class EntregaDTO {
    private Long id;
    private String nomeCliente;
    private BigDecimal frete;
    private StatusEntrega status;
    private OffsetDateTime dataPedido;
    private OffsetDateTime dataFinalizacao;
    private DestinatarioDTO destinatario;
}
