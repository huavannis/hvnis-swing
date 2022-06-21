package com.hvnis.swing.ranoffee;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayerPickerMouseListener implements ActionListener {

    private final PlayerPicker playerPicker;
    private final Player player;
    private final JLabel label;

    public PlayerPickerMouseListener(PlayerPicker playerPicker, Player player, JLabel label) {
        this.playerPicker = playerPicker;
        this.player = player;
        this.label = label;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!playerPicker.isSelected()) {
            final GamePlay gamePlay = GamePlay.getInstance();
            final GameState gameState = gamePlay.playEnd(player);
            playerPicker.selectPlayer(gameState, (JButton) e.getSource(), player, label);
        }
    }
}
