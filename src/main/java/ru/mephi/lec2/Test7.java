package ru.mephi.lec2;

// Образец класса
// Модификаторы\ключевые слова
// getter\setter
// POJO-класс

public class Test7 {
    private String a;
    private long   b;
    private Test5  t;

    public static void main(String[] args) {
        Test8 t = new Test8();
        t.getA();
    }

    public String getA() {
        return a;
    }
    public long   getB() {
        return b;
    }
    public Test5  getT() {
        return t;
    }

    public void setA(String a) {
        this.a = a;
    }
    public void setB(long   b) { this.b = b; }
    public void setT(Test5  t) { this.t = t; }
}
