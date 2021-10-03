package ru.mephi.lec4;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

// Применение интерфейса

public class Test1 implements Int1 {
    private int x;

    public Test1(int x) {
        this.x = x;
    }

    @Override
    public double foo(int x) {
        if (x >= 0) return this.x + x;
        throw new IllegalArgumentException("Expected parameter more or equals zero");
    }

    @Override
    public void boo(int y) {
        Int1.super.boo(y);
    }

    public static void print(Map<String, String> map) {
        map.forEach((k, v) -> System.out.println("key" + k + "]='" + v + "'"));
    }

    public static void main(String[] args) {
        Int1 int1 = new Test1(4);

        Map<String, String> map1 = new HashMap<>();
        Map<String, String> map2 = new LinkedHashMap<>();

        map1.put("map1", "hashmap");
        map2.put("map2", "linkedhashmap");

        print(map1);
        print(map2);
    }
}
