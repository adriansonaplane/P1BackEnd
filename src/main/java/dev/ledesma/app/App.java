package dev.ledesma.app;

import io.javalin.Javalin;

public class App {
    public static void main(String[] args) {

        Javalin app = Javalin.create();

        app.start();
    }
}
