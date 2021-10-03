package ru.mephi.lec1;

public class ArrayOperations {
    public static void main(String[] args) {
        String[] names    = new String[] { "Blue Shirt", "Red Shirt", "Black Shirt" };
        int[]    numbers  = new int[3];
        numbers[0] = 10;
        numbers[1] = 20;
        numbers[2] = 30;

        // For each - цикл
        for(String name: names)
            System.out.println("Name: " + name);

        for(int number: numbers)
            System.out.println("Number: " + number);
    }
}
