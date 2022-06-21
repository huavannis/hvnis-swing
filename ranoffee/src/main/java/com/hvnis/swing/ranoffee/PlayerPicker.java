package com.hvnis.swing.ranoffee;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.atomic.AtomicBoolean;

public class PlayerPicker extends JFrame {

    private final Home home;
    private final Player playingPlayer;
    private final AtomicBoolean selected;

    public PlayerPicker(Home home, Player playingPlayer) throws HeadlessException {
        this.home = home;
        this.playingPlayer = playingPlayer;
        this.selected = new AtomicBoolean(false);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        renderContentPanel();
    }

    private void renderContentPanel() {
        final JPanel panel = new JPanel();
        final FlowLayout flowLayout = new FlowLayout();
        flowLayout.setAlignment(FlowLayout.LEFT);
        flowLayout.setHgap(10);
        flowLayout.setVgap(10);
        panel.setLayout(flowLayout);
        renderAvailablePlayers(panel);
        this.getContentPane().add(panel);

    }

    private void renderAvailablePlayers(JPanel panel) {
        GamePlay.getInstance().getCurrentGameState().getPlayers().stream().filter(Player::isSelectable).forEach(player -> {
            panel.add(createAvailablePlayerComponent(player));
        });
    }

    private Component createAvailablePlayerComponent(Player player) {
        final JPanel panel = ComponentManager.getInstance().getComponentCreator().createPanel();
        final BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(boxlayout);
        panel.setPreferredSize(new Dimension(150, 160));
//        panel.setBorder(new RoundedBorder(10));
        panel.setBackground(Color.lightGray);

        final JButton button = new JButton();
        button.setIcon(getIcon("https://ca.slack-edge.com/T02G0PHRH-U9PHN04PJ-g474a167adb8-512"));
        button.setBackground(Color.lightGray);
        button.setPreferredSize(new Dimension(110, 110));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        final JLabel label = ComponentManager.getInstance().getComponentCreator().createLabel("Who am I");
        label.setSize(150, 30);
        button.addActionListener(new PlayerPickerMouseListener(this, player, label));

        final JPanel avatarPanel = ComponentManager.getInstance().getComponentCreator().createPanel();
        avatarPanel.setBackground(Color.lightGray);
        avatarPanel.add(button);

        final JPanel namePanel = ComponentManager.getInstance().getComponentCreator().createPanel();
        namePanel.setBackground(Color.lightGray);
        namePanel.add(label);

        panel.add(avatarPanel);
        panel.add(namePanel);

        return panel;
    }

    public boolean isSelected() {
        return selected.get();
    }

    public void selectPlayer(GameState gameState, JButton button, Player player, JLabel label) {
        selected.set(true);
        button.setIcon(getIcon(player.getAvatar()));
        button.getParent().setBackground(Color.WHITE);
        label.setText(player.getName());
        label.getParent().setBackground(Color.WHITE);
        home.renderContentPanel(gameState);
    }

    private ImageIcon getIcon(String url) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new URL(url));
        } catch (IOException e) {
            e.printStackTrace();
        }


        ImageIcon icon = null;
        if (img != null) {
            icon = new ImageIcon(img.getScaledInstance(100, 100, Image.SCALE_SMOOTH));
        }
        return icon;
    }

    private static class RoundedBorder implements Border {

        private int radius;

        RoundedBorder(int radius) {
            this.radius = radius;
        }
        @Override
        public Insets getBorderInsets(Component c) {
            return new Insets(this.radius, this.radius, this.radius, this.radius);
        }

        @Override
        public boolean isBorderOpaque() {
            return true;
        }

        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            g.drawRoundRect(x,y,width-1,height-1,radius,radius);
        }
    }
}
