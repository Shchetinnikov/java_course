package ru.mephi.lec3;

// Массивы. Объявление и инициализация

public class Test2 {
    public static void main(String[] args) {
        String[][] saa = new String[][] {
                {"ss1", "ss2", "ss3", "ss9"}, {"ss4", "ss5", "ss6"}, {"ss7", "ss8"}
        };

        for (String[] sa: saa) {
            for (int i = 0, len = sa.length; i < len; ++i)
                System.out.print("[_][" + i + "]='" + sa[i] + "', ");
            System.out.println();
        }
    }
}
