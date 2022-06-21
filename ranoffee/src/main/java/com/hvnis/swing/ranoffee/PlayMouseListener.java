package com.hvnis.swing.ranoffee;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayMouseListener implements ActionListener {

    private final Home home;
    private final Player player;

    public PlayMouseListener(Home home, Player player) {
        this.home = home;
        this.player = player;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        final GamePlay gamePlay = GamePlay.getInstance();
        gamePlay.playStart(player);
        final PlayerPicker playerPicker = new PlayerPicker(home, player);
        final int width = 650;
        final int height = 540;
        playerPicker.setSize(width, height);
        playerPicker.setTitle("Lucky Men");
        playerPicker.setAlwaysOnTop(true);
        playerPicker.toFront();
        playerPicker.setLocationRelativeTo(home);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        playerPicker.setLocation(dim.width / 2 + home.getWidth() / 2, dim.height / 2 - home.getHeight() / 2);
        playerPicker.setVisible(true);
    }
}
