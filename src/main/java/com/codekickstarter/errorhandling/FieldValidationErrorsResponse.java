package com.codekickstarter.errorhandling;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;

@JsonPropertyOrder({"message", "errors"})
public class FieldValidationErrorsResponse {

    public static FieldValidationErrorsResponse fromBindingResult(BindingResult bindingResult) {

        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        FieldValidationErrorsResponse response = new FieldValidationErrorsResponse();

        for (FieldError error : fieldErrors) {
            final FieldValidationError responseErrorMessage = new FieldValidationError();
            responseErrorMessage.setField(error.getField());
            responseErrorMessage.setMessage(error.getDefaultMessage());
            response.getErrors().add(responseErrorMessage);
        }

        return response;
    }

    public String getMessage() {
        return "There are validation errors.";
    }

    private List<FieldValidationError> errors = new ArrayList<>();

    public List<FieldValidationError> getErrors() {
        return errors;
    }

    public void setErrors(List<FieldValidationError> errors) {
        this.errors = errors;
    }
}
