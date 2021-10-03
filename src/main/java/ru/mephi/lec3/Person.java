package ru.mephi.lec3;

import java.util.Objects;

// Классы и методы
// Основные методы класса Object: toString(), equals() + hashCode(), clone()

// Интерфейс Cloneable - маркерный (пустышка)

public class Person implements Cloneable {
    private int    age;
    private String name;
    private String cachePerson;

    public Person(String name, int age) {
        this.age  = age;
        this.name = name;
    }

    public String getName() { return this.name; }
    public int    getAge()  { return age; }

    @Override
    public String toString() {
        if(this.cachePerson == null) {
            this.cachePerson = "Person{" +  "age=" + age + ", name='" + name + '\'' + '}';
        }
        return this.cachePerson;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false; // или !(o instanceof Person)
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() { return Objects.hash(age, name); }


    // клонирование объекта класса Person
    @Override
    public Person clone() throws CloneNotSupportedException {
        return (Person) super.clone();
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        // создаются на куче
        Person person  = new Person("sss", 10);
        Person person1 = new Person("sss", 10);
        User user      = new User("sss", 10, "sasf1");

        /*System.out.println(person);                           // вывод адреса
        System.out.println(person.toString());*/                // вывод словарем

        System.out.println(person.equals(person1));             // false, тк сравниваются адреса -> переопределяем equals

        // создаются на стэке
        /*Long l1 = Long.valueOf(2), l2 = Long.valueOf(2);      // <=>   new Long(2) */
        Long l1 = Long.valueOf(1024), l2 = Long.valueOf(1024);

        /*System.out.print(l1 == l2);*/                         // сравнение адресов
        System.out.print(l1.equals(l2));                        // сравнение значений

        Person person2 = user.clone();
        System.out.println(person2);

        update(person);
        System.out.printf("===> %s", person);
    }

    private static void update(Person person)
    {
        System.out.printf("Update person: %s%n", person);
        person = new Person("Кукурача", 200);
        System.out.printf("After update - person: %s%n", person);
    }
}
