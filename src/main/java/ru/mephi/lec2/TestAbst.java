package ru.mephi.lec2;

// Образец класса
// Модификаторы\ключевые слова
// Наследование\абстрактный класс

abstract public class TestAbst {
    private Test5 test5;

    public TestAbst(Test5 test5) {
        this.test5 = test5;
    }

    public int sum(int a, int b) {
        return a - b;
    }

//    protected abstract int div(int a, int b);

    public static void main(String[] args) {
        Test5 t5   = new Test5();
        TestAbst t = new TestAbst(t5) {
//            @Override
//            protected int div(int a, int b) {
//                return a + b;
//            }
        };
//        System.out.println(t.div(3, 5));
    }
}
