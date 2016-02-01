package com.codekickstarter.errorhandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Controller
public class GlobalRestApiExceptionController {

    @ExceptionHandler(InvalidFieldException.class)
    @ResponseBody
    public ResponseEntity<FieldValidationErrorsResponse> handleInvalidFieldException(InvalidFieldException e) {
        FieldValidationErrorsResponse errors = new FieldValidationErrorsResponse();
        errors.getErrors().add(new FieldValidationError(e.getField(), e.getMessage()));
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseEntity<FieldValidationErrorsResponse> handleValidationException(MethodArgumentNotValidException e) {
        FieldValidationErrorsResponse response = FieldValidationErrorsResponse.fromBindingResult(e.getBindingResult());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}
