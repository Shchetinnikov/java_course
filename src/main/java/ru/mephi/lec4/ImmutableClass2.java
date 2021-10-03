package ru.mephi.lec4;

// Неизменяемый класс (реализация 2)

public class ImmutableClass2 {
    public final int x;
    public final int y;

    ImmutableClass2(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
