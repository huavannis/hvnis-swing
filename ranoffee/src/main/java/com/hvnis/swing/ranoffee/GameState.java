package com.hvnis.swing.ranoffee;

import java.util.List;
import java.util.stream.Collectors;

public class GameState implements Cloneable {
    private final List<Player> players;

    public GameState(List<Player> players) {
        this.players = players;
    }

    public List<Player> getPlayers() {
        return players;
    }

    @Override
    protected GameState clone() {
        final List<Player> clonedPlayers = players.stream().map(Player::clone).collect(Collectors.toList());
        return new GameState(clonedPlayers);
    }
}
