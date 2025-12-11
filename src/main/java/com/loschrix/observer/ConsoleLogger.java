package com.loschrix.observer;

public class ConsoleLogger implements GameObserver {
    @Override
    public void onGameEvent(String message) {
        System.out.println("[LOG]: " + message);
    }
}
