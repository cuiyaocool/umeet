package com.example.daocommons.exception;


import lombok.Data;
import org.apache.logging.log4j.Level;

@Data
public class ApiException extends RuntimeException implements ICommonException {

    private ExceptionType exceptionType;

    public ApiException(String message, CommenExceptionType exceptionType) {
        super(composeMessage(exceptionType, message));
        this.exceptionType = exceptionType;
    }

    @Override
    public ExceptionType getExceptionType() {
        return exceptionType;
    }

    public Level getLogLevel() {
        return exceptionType.getLogLevel();
    }

    public ApiException(String message) {
        this(message, CommenExceptionType.UNKNOWN_EXCEPTION);
    }

    static String composeMessage(ExceptionType exceptionType, String message) {
        return "Message[" + exceptionType.getName() + "]: " + message;
    }

}
