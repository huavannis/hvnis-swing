package com.hvnis.swing.ranoffee;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

public class GameHistory {

    private final LinkedList<GameState> states;
    private final AtomicInteger currentStateIndex;

    public GameHistory() {
        this.states = new LinkedList<GameState>();
        this.currentStateIndex = new AtomicInteger(-1);
    }

    public boolean isFirst() {
        return currentStateIndex.get() <= 0;
    }

    public boolean isLast() {
        return currentStateIndex.get() >= states.size() - 1;
    }

    public GameState previous() {
        if (isFirst()) {
            return states.get(0);
        }
        final int previousIndex = currentStateIndex.decrementAndGet();
        return states.get(previousIndex);
    }

    public GameState next() {
        if (isLast()) {
            return states.get(states.size() - 1);
        }
        final int nextIndex = currentStateIndex.incrementAndGet();
        return states.get(nextIndex);
    }

    public void addState(GameState newState) {
        states.add(newState);
        currentStateIndex.incrementAndGet();
    }

    public GameState getCurrentGameState() {
        return states.get(currentStateIndex.get());
    }
}
