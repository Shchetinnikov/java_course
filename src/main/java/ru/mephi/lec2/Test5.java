package ru.mephi.lec2;

// Образец класса
// Модификаторы\ключевые слова

public class Test5 {
    public void info(String msg) { System.out.println("Message: " + msg); }

    public static void main(String[] args) {
        Test5 t = new Test5();
        t.info("Hello");
    }
}
