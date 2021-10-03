package ru.mephi.lec4;

// Логирование ошибок
// Slf4j-logger

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * На этапе байт-кода lombok подставляет инструкции/конструкции
 * @Slf4j - нотация фрейворка lombok
 */
//@Slf4j
public class ThirdException extends IOException {
    private static final Logger log = LoggerFactory.getLogger(ThirdException.class);
    public ThirdException(String message, Throwable cause) {
        super(message, cause);
    }

    public String method(String message) {
        // работа log зависит от выбора appender'a
        log.warn("Some problem: {}", message); // проверка уровня логирования для данного класса
        log.warn("Some problem: "  + message);
        return message;
    }
}
