package com.dev.ss.exception;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class ValidationExceptionDatails extends ExceptionDetails {
    private final String fields;
    private final String fieldsMessage;
}
