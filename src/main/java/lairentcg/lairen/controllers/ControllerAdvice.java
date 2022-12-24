package lairentcg.lairen.controllers;

import lairentcg.lairen.entidades.ErrorDTO;
import lairentcg.lairen.excepciones.EncontradoExcepcion;
import lairentcg.lairen.excepciones.NoEncontradoExcepcion;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(value = EncontradoExcepcion.class)
    public ResponseEntity<ErrorDTO> encontradoException(EncontradoExcepcion ex){
        ErrorDTO error = ErrorDTO.builder().codigo(ex.getCodigo()).mensaje(ex.getMessage()).build();
        return new ResponseEntity<>(error, ex.getStatus());
    }

    @ExceptionHandler(value = NoEncontradoExcepcion.class)
    public ResponseEntity<ErrorDTO> NoEncontradoException(NoEncontradoExcepcion ex){
        ErrorDTO error = ErrorDTO.builder().codigo(ex.getCodigo()).mensaje(ex.getMessage()).build();
        return new ResponseEntity<>(error, ex.getStatus());
    }

}
