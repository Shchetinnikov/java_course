package ru.mephi.lec2;

// Образец класса
// Модификаторы\ключевые слова
// Наследование\абстрактный класс
// Блоки

public class Test6 extends TestAbst {
    private static final int y = 1;
    private static       int z = 1;
    private              int x = 5;
    public final Test5 abc;

    // Блок
    {
        x = 10;
        System.out.println("x2 = " + x);
    }

    public Test6() {
        this(new Test5());
    }
    public Test6(Test5 test5) {
        super(test5);
        System.out.println("x0 = " + x);
        this.x = 1;
        System.out.println("x1 = " + x);
        this.abc = test5;
    }
    public Test6(int x, Test5 t, Test5 abc) {
        super(t);
        this.abc = abc;
        this.x = x;
    }

    public void xx(int x, Test5 t, String... m) {}

    public static void main(String[] args) {
        Test6 t = new Test6(new Test5());
    }


    // Статический блок
    /* позволяет изменять значения только статических полей */
    static
    {
        System.out.println("z0 = " + z);
        z = 0;
        System.out.println("z1 = " + z);

    }
}
