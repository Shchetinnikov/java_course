package ru.mephi.lec1;

public class WhileStatement {
    public static void main(String[] args) {
        int i = 1;

        while (i < 10) {
            System.out.println("value of i: " + i);
            i++;
        }

        System.out.println();

        do {
            System.out.println("value of i: " + i);
            i++;
        } while (i < 20);

    }
}
