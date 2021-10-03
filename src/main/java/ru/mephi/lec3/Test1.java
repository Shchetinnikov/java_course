package ru.mephi.lec3;

// Массивы. Объявление и инициализация

// утилитный класс Arrays (документация на docs.oracle.com)
import java.util.Arrays;

public class Test1 {
    public static void main(String[] args) {
        Integer[] ia1 = new Integer[] {1 ,2, 3};
        Integer[] ia2 = new Integer[] {1 ,2, 4};

        System.out.println(Arrays.equals(ia1, ia2));        // проверка равенства
        System.out.println(Arrays.mismatch(ia1, ia2));      // индекс элемента несовпадения : -1 - не нашел различия
        System.out.println(Arrays.toString(ia1));           // вывод в формате [1, 2, 3]

        int[] a1 = new int[] {-1, 11, -4};
        int[] a2 = new int[] {-1, 2, -4};
        System.out.println(Arrays.compareUnsigned(a1, a2));
        System.out.println(Arrays.compare(a1, a2));

        // Размер массива может задаваться переменной
        int len = 2;
        Integer[] aa = new Integer[len];
        Arrays.fill(aa, 10);                            // заполнение элементов массива числом 10
        System.out.println(Arrays.toString(aa));
    }

}
