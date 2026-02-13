package FacadeJunimo;

import java.util.ArrayList;
import java.util.List;

public class GameEventSystem {
    private final List<GameObserver> observers = new ArrayList<>();

    public void subscribe(GameObserver observer) {
        observers.add(observer);
    }

    public void notify(String message) {
        for (GameObserver observer : observers) {
            observer.onGameEvent(message);
        }
    }
}
