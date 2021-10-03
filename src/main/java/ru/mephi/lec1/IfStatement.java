package ru.mephi.lec1;

public class IfStatement {
    public static void main(String[] args) {
        int  a = 1;
        long b = 2;

        // в Java в условии всегда должны стоять выражения, которые соот. булевскому значению
        // в отличие от С++, где еще можно подставлять изолированно переменные
        if (a == b || a > 1 && b < 0) {
            System.out.println("Equal");
        } else {
            System.out.println("Unequal");
        }

        if (a == b | a > 1 & b < 0) {
            System.out.println("Equal");
        } else {
            System.out.println("Unequal");
        }
    }
}
