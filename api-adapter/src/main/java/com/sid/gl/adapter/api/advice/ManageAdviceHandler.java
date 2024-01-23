package com.sid.gl.adapter.api.advice;

import com.sid.gl.common.dto.ErrorDTO;
import com.sid.gl.common.exceptions.BadArgumentsException;
import com.sid.gl.common.exceptions.DomainException;
import com.sid.gl.common.exceptions.ResourceNotFoundException;
import com.sid.gl.common.exceptions.ValidationException;
import com.sid.gl.common.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestControllerAdvice
public class ManageAdviceHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse<?> handleMethodArgumentException(MethodArgumentNotValidException exception){
        ApiResponse<?> apiResponse = new ApiResponse<>();
        List<ErrorDTO> errors = new ArrayList<>();
        exception.getBindingResult().getFieldErrors()
                .forEach(fieldError -> {
                    ErrorDTO errorDTO = new ErrorDTO(fieldError.getField(), fieldError.getDefaultMessage());
                    errors.add(errorDTO);
                });

        apiResponse.setStatus("FAILED");
        apiResponse.setErrorDTOS(errors);
        return apiResponse;
    }

    @ExceptionHandler(BadArgumentsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse<?> handleServiceBussnessValidatorException(BadArgumentsException exception){
        ApiResponse<?> response = new ApiResponse<>();
        response.setErrorDTOS(Collections.singletonList(new ErrorDTO("", exception.getMessage())));
        response.setStatus("FAILED");
        return response;
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiResponse<?> handleServiceBussnessValidatorException(ResourceNotFoundException exception){
        ApiResponse<?> response = new ApiResponse<>();
        response.setErrorDTOS(Collections.singletonList(new ErrorDTO("", exception.getMessage())));
        response.setStatus("FAILED");
        return response;
    }

    @ExceptionHandler(ValidationException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiResponse<?> handleServiceBussnessValidatorException(ValidationException exception){
        ApiResponse<?> response = new ApiResponse<>();
        response.setErrorDTOS(Collections.singletonList(new ErrorDTO("", exception.getMessage())));
        response.setStatus("FAILED");
        return response;
    }

    @ExceptionHandler(DomainException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiResponse<?> handleServiceBussnessValidatorException(DomainException exception){
        ApiResponse<?> response = new ApiResponse<>();
        response.setErrorDTOS(Collections.singletonList(new ErrorDTO("", exception.getMessage())));
        response.setStatus("FAILED");
        return response;
    }

}
