package com.hvnis.swing.ranoffee;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GamePlay {

    private static final GamePlay INSTANCE = new GamePlay();

    private final GameHistory gameHistory;
    private Player playerPlaying;

    public static GamePlay getInstance() {
        return INSTANCE;
    }

    public GamePlay() {
        this.gameHistory = new GameHistory();
    }

    public GameState initGamePlay() {
        final List<Player> players = Arrays.asList(
                new Player(1, "Dang Dinh", "https://ca.slack-edge.com/T02G0PHRH-U018BJHDX52-088df36cf225-512"),
                new Player(2, "Hung Nguyen", "https://ca.slack-edge.com/T02G0PHRH-UEWNLD1PA-a9c24bde0cc2-512"),
                new Player(3, "Khanh Huynh", "https://ca.slack-edge.com/T02G0PHRH-U0116QVPBFV-g71f47bcaeaf-512"),
                new Player(4, "Lam Ho", "https://ca.slack-edge.com/T02G0PHRH-U01H02Z5DJ5-994619a7b1da-512"),
                new Player(5, "Nis Hua", "https://ca.slack-edge.com/T02G0PHRH-UTF0DKHPW-6def62b553cf-512"),
                new Player(6, "Phong Nguyen Duy", "https://ca.slack-edge.com/T02G0PHRH-UEX9SL6AG-15f1456ca067-512"),
                new Player(7, "Sang Cong", "https://ca.slack-edge.com/T02G0PHRH-UD1EP1M6H-fefb6a26edb0-512"),
                new Player(8, "Sang Truong", "https://ca.slack-edge.com/T02G0PHRH-UUZ9S77C0-1203546d6843-512"),
                new Player(9, "Thong Do", "https://ca.slack-edge.com/T02G0PHRH-U02R05B74RE-42730d9b080c-512"),
                new Player(10, "Thuan Tran", "https://ca.slack-edge.com/T02G0PHRH-U01H8QPFPF0-22d0df94ad8c-512"),
                new Player(11, "Tien Bien", "https://ca.slack-edge.com/T02G0PHRH-U45HN93A4-da0cea7f5c3c-512")
//                new Player(12, "Tu Ngo", "https://ca.slack-edge.com/T02G0PHRH-U33LS400Z-af00c5d67a49-512")
        );
        final GameState initGameState = new GameState(players);
        gameHistory.addState(initGameState);
        return initGameState;
    }

    public void setPlayerSelectable(Player player, boolean selectable) {
        gameHistory.getCurrentGameState().getPlayers().stream().filter(p -> p.getId() == player.getId()).findFirst().ifPresent(pl -> pl.setSelectable(selectable));
    }

    public GameState getCurrentGameState() {
        return gameHistory.getCurrentGameState();
    }

    public void playStart(Player player) {
        if (playerPlaying != null) {
            return;
        }
        this.playerPlaying = player;
        final GameState newGameState = gameHistory.getCurrentGameState().clone();
        Collections.shuffle(newGameState.getPlayers());
        gameHistory.addState(newGameState);
    }

    public GameState playEnd(Player selectedPlayer) {
        final GameState currentGameState = gameHistory.getCurrentGameState();
        currentGameState.getPlayers().stream().filter(p -> p.getId() == selectedPlayer.getId()).findFirst().ifPresent(Player::increaseCount);
        currentGameState.getPlayers().stream().filter(p -> p.getId() == playerPlaying.getId()).findFirst().ifPresent(pl -> pl.setPlayed(true));
        playerPlaying = null;
        return currentGameState;
    }

    public GameState playEnd() {
        final GameState currentGameState = gameHistory.getCurrentGameState();
        currentGameState.getPlayers().stream().filter(p -> p.getId() == currentGameState.getPlayers().get(0).getId()).findFirst().ifPresent(Player::increaseCount);
        currentGameState.getPlayers().stream().filter(p -> p.getId() == playerPlaying.getId()).findFirst().ifPresent(pl -> pl.setPlayed(true));
        playerPlaying = null;
        return currentGameState;
    }
}
