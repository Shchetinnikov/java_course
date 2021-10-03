package ru.mephi.lec1;

public class HelloWorld {
    public static void main(String[] args) {
        // вывод в консоль
        System.out.println("Hello, world!");

        // пример бинарной записи чисел
        byte i = 0x10;
        System.out.println(10000F);

        // создание массива
        int[] a = new int[2];

        // указанные строки будут иметь один адрес, несмотря на разные переменные
        String s1 = "aaa";
        String s2 = "aaa";
        System.out.println(s1 == s2);
    }
}
