package com.maxamx.logista.domain.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Cliente {

    private Long id;
    private String nome;
    private String email;
    private String telefone;

}
