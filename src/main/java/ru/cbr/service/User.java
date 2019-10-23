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
        nestedMethod1();
        nestedMethod2();

        Thread.sleep(500);
        System.out.println("User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}');
    }

    @ExecutionTime
    private void nestedMethod1() throws InterruptedException {
        Thread.sleep(100);
        System.out.println("1st nested method complete");
    }

    @ExecutionTime
    private void nestedMethod2() throws InterruptedException {
        nestedMethod3();
        nestedMethod4();

        Thread.sleep(200);
        System.out.println("2nd nested method complete");
    }

    @ExecutionTime
    public void nestedMethod3() throws InterruptedException {
        Thread.sleep(300);
        System.out.println("3rd nested method complete");
    }

    @ExecutionTime
    public void nestedMethod4() throws InterruptedException {
        Thread.sleep(400);
        System.out.println("4th nested method complete");
    }
}
