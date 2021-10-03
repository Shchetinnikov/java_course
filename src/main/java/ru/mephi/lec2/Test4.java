package ru.mephi.lec2;

// Образец класса
// Модификаторы\ключевые слова
// Наследование
// Видимость классов одного пакета

// По умолчанию, класс (при отсутствии явного указания extends) наследуется от базового класса Object
import java.lang.Object;

public class Test4 extends Test1 {
    protected Test2 test2;

    Test4(int x, Test2 test2) {
        super(x);
        this.test2 = test2;
    }

    public String fullName(String last) {
        return super.fullName(last) + test2.fullName(last);
    }
}
