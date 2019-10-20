package ru.cbr;

import ru.cbr.service.User;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        User user = new User(30, "Dmitry");
        user.getData();
    }
}
