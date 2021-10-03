package ru.mephi.lec3;

// Дочерний класс User класса Person

public class User extends Person {
    private final String login;

    public User(String name, int age, String login) {
        super(name, age);
        this.login = login;
    }

    public String getLogin() { return login; }

    @Override
    public String toString() {
        return "User{" + "login='" + login + '\'' + '}';
    }
}
