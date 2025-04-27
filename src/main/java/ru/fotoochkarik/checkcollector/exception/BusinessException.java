package ru.fotoochkarik.checkcollector.exception;

public class BusinessException  extends BaseException{

    public BusinessException(String message, String codeError) {
        super(message, codeError);
    }

}
