package ru.mephi.lec3;

public class Test3
{
    public String method1(String a, Integer b) { return ": " + b + " : "  + a; }
    public String method1(String a, int     b) { return "[ " + b + " ] " + a;  }
    public String method1(String a, Long    b) { return "::" + b + ":: " + a;  }
    public String method1(String a, Object  b) { return "{ " + b + " } " + a;  }
    public String method1(String a)            { return ">>" + a;              }
    public int    method1(String a, String  b) { return Integer.parseInt(a);   }

    public static void main(String[] args) throws CloneNotSupportedException {
        Test3 t = new Test3();
        System.out.println(t.method1("with Integer ", Integer.valueOf(4)));
        System.out.println(t.method1("with int "    , 2));
        System.out.println(t.method1("with Long "   , Long.valueOf(5)));
        System.out.println(t.method1("with long "   , 6L));
        System.out.println(t.method1("with Object " , 1.));
        System.out.println(t.method1("simple string")) ;
        System.out.println(t.method1("with null", (Integer) null));
    }
}
