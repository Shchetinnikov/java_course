package ru.mephi.lec2;

// Образец класса
// Модификаторы\ключевые слова

// Использование библиотеки lombok вместо реализации Test7
import lombok.Data;

@Data
public class Test8 {
    private String a;
    private long   b;
    private Test5  t;

    public static void main(String[] args) {
        Test8 t = new Test8();
        t.getA();
    }
}
