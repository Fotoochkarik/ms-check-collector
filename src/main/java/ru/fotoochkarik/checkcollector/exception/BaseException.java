package ru.fotoochkarik.checkcollector.exception;

import lombok.Getter;

@Getter
public abstract class BaseException extends RuntimeException {
    /**
     * Код ошибки, передается во внешнюю систему
     */
    private final String errorCode;

    public BaseException(String message, String errorCode) {
        super(String.format("System error %s: %s", errorCode, message));
        this.errorCode = errorCode;
    }

    public BaseException(String errorCode) {
        super(String.format("System error with code: %s", errorCode));
        this.errorCode = errorCode;
    }

}
