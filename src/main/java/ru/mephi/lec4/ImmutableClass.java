package ru.mephi.lec4;

// Неизменяемый класс (реализация 1)

public class ImmutableClass {
    public int x;
    public int y;

    ImmutableClass(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
}


