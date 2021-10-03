package ru.mephi.lec1;

public class SwitchStatement {
    public static void main(String[] args) {
        /**
         * Edit Configurations -> Build and Run -> Program arguments или
         * Запуск программы через консоль с передачей параметра
         */

        String color = args[0];     //"Blue";
        String shirt = "Shirt";

        switch(color) {
            case "Blue":
                shirt = "Blue " + shirt;
                break;
            case "Red":
                shirt = "Red " + shirt;
                break;
            default:
                shirt = "White " + shirt;
        }
        System.out.println("Shirt type: " + shirt);
    }
}
