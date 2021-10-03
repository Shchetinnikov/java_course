package ru.mephi.lec2;

// Образец класса
// Модификаторы\ключевые слова

public class Test2 {
    private final String name;

    public Test2(String name) { this.name = name; }

    public String getName ()            { return name; }
    public String fullName(String last) { return getName() + " " + last; }

    public static void main(String[] args) {
        Test1 t = new Test1(2);
    }
}
