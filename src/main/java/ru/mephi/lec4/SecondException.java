package ru.mephi.lec4;

import java.io.IOException;

public class SecondException extends IOException {
    public SecondException(String message, Throwable cause) {
        super(message, cause);
    }
}
