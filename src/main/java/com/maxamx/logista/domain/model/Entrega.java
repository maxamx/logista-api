package com.maxamx.logista.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.maxamx.logista.api.funcionalinterface.ValidationGroups;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Entrega {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Cliente cliente;


    @Embedded
    private Destinatario destinatario;


    private BigDecimal taxa;


    @Enumerated(EnumType.STRING)
    private StatusEntrega status;


    private OffsetDateTime dataPedido;


    private OffsetDateTime dataFinalizacao;

    @OneToMany(mappedBy = "entrega",cascade = CascadeType.ALL)
    private List<Ocorrencia> ocorrencias=new ArrayList<>();

    public Ocorrencia adiconarOcorrencia(String descricao) {
        Ocorrencia ocorrencia = new Ocorrencia();
        ocorrencia.setDescricao(descricao);
        ocorrencia.setDataRegistro(OffsetDateTime.now());
        ocorrencia.setEntrega(this);
        this.getOcorrencias().add(ocorrencia);

        return ocorrencia;
    }
}
