package ru.mephi.lec5;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RangeList {

    static List<Integer> rangeList(int fromInclusive, int toExclusive) {
        return new AbstractList<Integer>() {
            @Override
            public Integer get(int index) {
                if (index < 0 || index >= size()) {
                    throw new IndexOutOfBoundsException();
                }
                return fromInclusive + index;
            }

            @Override
            public int size() {
                return toExclusive - fromInclusive;
            }
        };
    }

    public static void main(String[] args) {
        List<String> list = List.of("12", "23"), list1 = new ArrayList<>(list);
        list1.add("12");
        list1.add("23");
        List<String> list2 = Arrays.asList("12", "23");
        List<String> list3 = List.copyOf(list);
    }
}
