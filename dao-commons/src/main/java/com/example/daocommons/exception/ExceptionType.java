package com.example.daocommons.exception;

import org.apache.logging.log4j.Level;

public interface ExceptionType {
    /**
     * 发生异常的模块.
     */
    public static enum Scope {
        WEB,
        RPC,
        DB,
        THIRD_PARTY
    }

    /**
     * @return Error code of this exception type, which is usually passed to
     * the clients.
     */
    public int getErrorCode();

    /**
     * @return log level of this exception. Exception message would be logged
     * for INFO level. And exception stack trace would be logged for exception
     * above WARN.
     */
    public Level getLogLevel();

    /**
     * @return name of the exception type
     */
    public String getName();

    /**
     * Inform client whether to retry again is needed when this exception happen.
     * @return
     */
    public boolean canTryAgain();

    /**
     * Blame the happening of this exception to where.
     * @return
     */
    public Scope getScope();

}
