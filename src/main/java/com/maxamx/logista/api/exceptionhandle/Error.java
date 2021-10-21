package com.maxamx.logista.api.exceptionhandle;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class Error {
    private Integer status;
    private LocalDateTime localDateTime;
    private String titulo;
    private List<Campo> campos;

    @AllArgsConstructor
    @Getter
    public static class Campo{
        private String nome;
        private String mensagem;
    }
}
