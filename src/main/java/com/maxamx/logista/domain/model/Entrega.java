package com.maxamx.logista.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Entrega {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Valid
    @NotNull
    @ManyToOne
    private Cliente cliente;

    @Embedded
    private Destinatario destinatario;

    @NotNull
    private BigDecimal taxa;

    @JsonProperty(access= JsonProperty.Access.READ_ONLY)
    @Enumerated(EnumType.STRING)
    private StatusEntrega status;

    @JsonProperty(access= JsonProperty.Access.READ_ONLY)
    private LocalDateTime dataPedido;

    @JsonProperty(access= JsonProperty.Access.READ_ONLY)
    private LocalDateTime dataFinalizacao;


}
