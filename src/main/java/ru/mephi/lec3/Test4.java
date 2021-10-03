package ru.mephi.lec3;

public class Test4 extends Test3
{
    @Override
    public String method1(String a, int b)    { return "Test2 -> " + super.method1(a, b); }

    @Override
    public String method1(String a, Object b) { return "Test2 -> " + super.method1(a, b);}

    @Override
    public String method1(String a)           { return "Test2 -> <без вызова метода родителя>" + a; }

    public static void main(String[] args) {
        Test4 t = new Test4();
        System.out.println(t.method1("переопределение объекта", "string"));
        System.out.println(t.method1("переопределение объекта", 10L));
    }
}
