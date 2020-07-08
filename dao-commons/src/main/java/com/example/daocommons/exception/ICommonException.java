package com.example.daocommons.exception;


import org.apache.logging.log4j.Level;

public interface ICommonException {

    public ExceptionType getExceptionType();

    public static enum CommenExceptionType implements ExceptionType {

        UNKNOWN_EXCEPTION(1000),
        JSON_PARSE_EXCEPTION(1001),
        ILLEGAL_PARAM(1002),
        STORE_SERVICE_EXCEPTION(1003),
        NOT_FOUND(1004),
        UNKNOWN_ENUM(1005),
        INITIALIZE_ERROR(1006),
        REPLAY_ERROR(1007),
        UNSUPPORTED_FORMAT(1008),
        OPERATION_FORBIDDEN(1009),
        OPERATION_FAILED(1010),
        TARGET_NOT_EXIST(1011);


        final int code;
        final Level level;
        CommenExceptionType(int code) {
            this(code, Level.INFO);
        }

        CommenExceptionType(int code, Level level) {
            this.code = code;
            this.level = level;
        }


        @Override
        public int getErrorCode() {
            return code;
        }

        @Override
        public org.apache.logging.log4j.Level getLogLevel() {
            return level;
        }

        @Override
        public String getName() {
            return name();
        }

        @Override
        public boolean canTryAgain() {
            return false;
        }

        @Override
        public Scope getScope() {
            return Scope.WEB;
        }
    }
}
