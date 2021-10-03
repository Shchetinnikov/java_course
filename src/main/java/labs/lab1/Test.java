package labs.lab1;

import static java.lang.System.out;

class Test {
    public static void main(String[] args) {
        out.println();
        out.println("************ LinkedList testing ************");
        {
            String[] colors  = new String[] { "Blue", "Red", "Black", "Green", "White", "Brown" };

            LinkedList list1 = new LinkedList(colors, 10);
            LinkedList list2 = new LinkedList(5);
            LinkedList list3 = new LinkedList(list1);

            out.println(list1.toString());
            out.println(list2.toString());
            out.println(list3.toString());

            list1.set(0, "Orange");
            out.println(list3.toString());

            out.println(list1.getLength());
            out.println(list1.getFirst());
            out.println(list1.getLast());
            out.println(list1.get(4));
            out.println(list1.hasValue(4));
            out.println(list1.indexOf("Black"));

            list1.append("Pink");
            out.println(list1.toString());

            list1.prepend("Yellow");
            out.println(list1.toString());

            list1.set(0, "Pink");
            out.println(list1.toString());

            list1.insertAt(4, "Pink");
            out.println(list1.toString());

            list1.removeAt(4);
            out.println(list1.toString());

            list1.remove("Red");
            out.println(list1.toString());

            list1.removeAt(0);
            out.println(list1.toString());

            list1.removeAt(list1.getLength());
            out.println(list1.toString());

            list1.removeAt(-4);
            out.println(list1.toString());
        }

        out.println();
        out.println("************ DynamicArray testing ************");
        {
            String[] colors  = new String[] { "Blue", "Red", "Black", "Green", "White", "Brown" };

            DynamicArray list1 = new DynamicArray(colors, 10);
            DynamicArray list2 = new DynamicArray(5);
            DynamicArray list3 = new DynamicArray(list1);

            out.println(list1.toString());
            out.println(list2.toString());
            out.println(list3.toString());

            list1.set(0, "Orange");
            out.println(list3.toString());

            out.println(list1.getSize());
            out.println(list1.get(3));
            out.println(list1.hasValue(3));

            list1.set(0, "Pink");
            out.println(list1.toString());

            list1.resize(7);
            out.println(list1.toString());
        }

        out.println();
        out.println("************ HashTable testing ************");
        {
            HashTable table1 = new HashTable(8);
            HashTable table2 = new HashTable(16);
            HashTable table3 = new HashTable(table2);

            out.println(table1.getCapacity());
            out.println(table2.getCapacity());
            out.println(table3.getCapacity());

            out.println(table1.getCount());
            out.println(table2.getCount());
            out.println(table3.getCount());

            out.println(table1.get(1));
            out.println(table1.find(1));

            int[] keys = new int[]{1, 32, 5, 27, 11, 0, 17};
            String[] values = new String[]{"One", "Thirty two", "Five", "Twenty seven", "Eleven", "Zero", "Seventeen"};

            for (int i = 0; i < keys.length; i++) {
                table1.add(keys[i], values[i]);
            }

            out.println(table1.get(27));
            out.println(table1.find(27));

            out.println(table1.getCount());

            for (int i = 0; i < 5; i++)
                out.println(table1.remove(keys[i]));

            out.println(table1.getCapacity());
            out.println(table1.getCount());

            int[] keys2 = new int[]{2, 33, 6, 28, 12, 3, 18};
            String[] values2 = new String[]{"Two", "Thirty three", "Six", "Twenty eight", "Twelve", "Three", "Eighteen"};


            for (int i = 0; i < keys2.length; i++)
                out.println(table1.add(keys2[i], values2[i]));

            out.println(table1.getCapacity());
            out.println(table1.getCount());
        }

        out.println();
        out.println("************ Map testing ************");
        {
            int[] keys = new int[]{2, 33, 6, 28, 12, 3, 18};
            String[] values = new String[]{"Two", "Thirty three", "Six", "Twenty eight", "Twelve", "Three", "Eighteen"};

            Map map = new Map();

            for (int i = 0; i < keys.length; i++) {
                map.put(keys[i], values[i]);
            }

            out.println(map.getKeys().toString());
            out.println(map.getValues().toString());
        }
    }
}
