package com.maxamx.logista.api.exceptionhandle;

import com.maxamx.logista.domain.model.exception.ClienteException;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    private MessageSource messageSource;

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,  HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<Error.Campo> campos = new ArrayList<>();

        for(ObjectError objectError : ex.getBindingResult().getAllErrors()){
            String nome = ((FieldError) objectError).getField();
            String mensagem = messageSource.getMessage(objectError, LocaleContextHolder.getLocale());
            campos.add((new Error.Campo(nome,mensagem)));
        }

        Error error = new Error();
        error.setStatus(status.value());
        error.setLocalDateTime(OffsetDateTime.now());
        error.setTitulo("Os campos estão inválidos. Faça o preenchimento correto e teste novamente");
        error.setCampos(campos);

        return handleExceptionInternal(ex, error,headers, status, request);
    }


    @ExceptionHandler(ClienteException.class)
    public ResponseEntity<Object> handleClienteException(ClienteException cliex, WebRequest request){
        HttpStatus status = HttpStatus.BAD_REQUEST;

        Error error = new Error();
        error.setStatus(status.value());
        error.setLocalDateTime(OffsetDateTime.now());
        error.setTitulo(cliex.getMessage());

        return handleExceptionInternal(cliex,error,new HttpHeaders(),status,request);
    }



}
