package com.liukhtenko.taskShape.exeption;

public class TypeOfFigureNotPresentExeption extends Exception {
    public TypeOfFigureNotPresentExeption() {
        super();
    }

    public TypeOfFigureNotPresentExeption(String message) {
        super(message);
    }

    public TypeOfFigureNotPresentExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public TypeOfFigureNotPresentExeption(Throwable cause) {
        super(cause);
    }

    protected TypeOfFigureNotPresentExeption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
