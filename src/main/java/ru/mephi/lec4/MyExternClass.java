package ru.mephi.lec4;

// Вложенные классы (inner class) (примечание: public)

/**
 *  Один из потенциальных вариантов утечки памяти:
 *    внутренний класс всегда имеет ссылку на внешний класс,
 *    поэтому при возвращении в программу объекта внутреннего класса
 *    объект внешнего класса продолжает существовать.
 */

public class MyExternClass {
    private int x;
    private int y;

    public MyExternClass(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public class MyInnerClass{
        public void print() {
            System.out.println("MyClass(x=" + x + ", y=" + y);
        }
    }
}
