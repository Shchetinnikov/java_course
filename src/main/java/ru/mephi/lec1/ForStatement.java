package ru.mephi.lec1;

public class ForStatement {
    public static void main(String[] args) {
        for (int i = 0; i < 10; ++i)
            System.out.println("i: " + i);

        for (int i = 0, len = 10; i < len; ++i)
            System.out.println("i: " + i);
    }
}
