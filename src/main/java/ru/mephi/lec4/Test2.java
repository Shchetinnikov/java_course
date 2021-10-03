package ru.mephi.lec4;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test2 {
    public static void main(String[] args) throws ParseException {
        // checking - исключение
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        date = format.parse("11.12.2021"); // в parse добавлено проверяемое исключение ParseException

        Integer integer = Integer.valueOf("2345");
    }
}
