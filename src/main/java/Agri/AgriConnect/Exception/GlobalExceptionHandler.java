package Agri.AgriConnect.Exception;

import Agri.AgriConnect.Dto.MessageResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<MessageResponseDto> handleRuntimeException(RuntimeException ex) {

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new MessageResponseDto(ex.getMessage()));
    }
}