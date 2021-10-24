package com.maxamx.logista.api.dto.output;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DestinatarioOutputDTO {
    private String nome;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
}
