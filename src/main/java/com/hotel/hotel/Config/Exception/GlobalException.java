package com.hotel.hotel.Config.Exception;

import com.hotel.hotel.Config.Dto.MessageDto;
import com.hotel.hotel.Utils.Operations;

import jakarta.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<MessageDto> throwNotFoundException(ResourceNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new MessageDto(HttpStatus.NOT_FOUND, e.getMessage()));
    }

    @ExceptionHandler(AttributeException.class)
    public ResponseEntity<MessageDto> throwAttributeException(AttributeException e) {
        return ResponseEntity.badRequest()
                .body(new MessageDto(HttpStatus.BAD_REQUEST, e.getMessage()));
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<MessageDto> validationExceptions(MethodArgumentNotValidException e) {
        System.out.println("Entro al error de validacion");
        List<String> messages = new ArrayList<>();
        e.getBindingResult().getAllErrors().forEach((err) -> {
            messages.add(err.getDefaultMessage());
        });
        return ResponseEntity.badRequest()
                .body(new MessageDto(HttpStatus.BAD_REQUEST, Operations.trimBrackets(messages.toString())));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<MessageDto> validationException(MethodArgumentNotValidException e) {
        List<String> messages = new ArrayList<>();
        System.out.println("Entro al error de validacion");
        e.getBindingResult().getAllErrors().forEach((err) -> {
            messages.add(err.getDefaultMessage());
        });
        return ResponseEntity.badRequest()
                .body(new MessageDto(HttpStatus.BAD_REQUEST,
                        Operations.trimBrackets(messages.toString())));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<MessageDto> generalException(Exception e) {
        System.out.println("Entro al error general");
        return ResponseEntity.internalServerError()
                .body(new MessageDto(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage()));
    }

}