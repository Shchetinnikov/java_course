// Указание, что класс принадлежит определенному пакету
package ru.mephi.lec1;

import java.util.Scanner; // импорт класса Scanner
import java.util.*;       // импорт всех классов пакета java.util

/**
 * Cтатический импорт классов System и Math. Эти классы имеют статические методы.
 * Благодаря операции статического импорта мы можем использовать эти методы
 * без названия класса. Например, писать не Math.sqrt(20), а sqrt(20),
 * так как функция sqrt(), которая возвращает квадратный корень числа, является статической.
 */
import static java.lang.System.*;
import static java.lang.Math.*;


public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

//        java.sql.Date sqlDate = new java.sql.Date();
        java.util.Date utilDate = new java.util.Date();
    }
}
