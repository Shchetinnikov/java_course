package ru.mephi.lec4;

import lombok.NonNull;

// Интерфейс

/**
 * default-методы определены по умолчанию, но их можно переопределять;
 * можно вызывать только после получения экземпляр класса
 *
 * у методов нет модификаторов (по умолчанию public)
 * у переменных нет модификаторов (по умолчанию public static final)
 */

public interface Int1 {
    // Документация интрефейса
    /**
     * Принимаю только положительные значения
     * @param x <code>int</code>
     * @return <code>double</code>
     */
    double foo(int x);

    /**
     *
     * @param y <code>int</code>
     */
    default void boo(int y) {
        // Не можем пользоваться this
        System.out.println(XX + " , " + ss + "': " + y);
        foo(y);
    }

    int XX = 1;
    String ss = "ыывы";

//    void zoo(@NonNull Integer y);
}