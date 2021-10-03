package ru.mephi.lec2;

// Образец класса
// Модификаторы
// Статические методы

public class Test1 {
    private int x;
    private static class Test11 {
        public int amount() {
            return 2 * new Test1(2).x;
        }
    }

    Test1(int x) { this.x = x; }

    protected void info() { System.out.println(x); }
    String fullName(String last) { return last; }

    public static void main(String[] args) {
        Test1 t = new Test1(2);
        System.out.println(t.x);
        t.info();
    }
}
