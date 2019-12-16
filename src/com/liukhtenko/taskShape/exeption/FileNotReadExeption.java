package com.liukhtenko.taskShape.exeption;

public class FileNotReadExeption extends Exception {
    public FileNotReadExeption() {
        super();
    }

    public FileNotReadExeption(String message) {
        super(message);
    }

    public FileNotReadExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public FileNotReadExeption(Throwable cause) {
        super(cause);
    }
}
