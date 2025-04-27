package ru.fotoochkarik.checkcollector.exception;

public class EssenceNotFoundException extends BaseException{

    public EssenceNotFoundException(String message, String codeError) {
        super(message, codeError);
    }

}
