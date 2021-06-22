package br.com.hql.exception;

import br.com.hql.dto.ErrorExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiException {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorExceptionDTO> handleError (UserNotFoundException ex ) {
        return new ResponseEntity(ErrorExceptionDTO.builder().msg(ex.getMessage()).build(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
