package ru.cbr.service;

import ru.cbr.inspect.ExecutionTime;

public class User {
    private int age;
    private String name;

    public User(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @ExecutionTime
    public void getData() throws InterruptedException {
        Thread.sleep(500);
        System.out.println("User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}');
    }
}
