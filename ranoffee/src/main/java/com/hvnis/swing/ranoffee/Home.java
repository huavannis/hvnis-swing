package com.hvnis.swing.ranoffee;

import com.hvnis.swing.core.component.CheckBox;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

public class Home extends JFrame {

    private final PlayMode playMode;

    public Home(PlayMode playMode) throws HeadlessException {
        this.playMode = playMode;
        final GameState gameState = GamePlay.getInstance().initGamePlay();
        renderContentPanel(gameState);
    }

    public void renderContentPanel(GameState gameState) {
        this.getContentPane().removeAll();
        this.getContentPane().revalidate();
        this.getContentPane().repaint();
        final JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        final FlowLayout flowLayout = new FlowLayout();
        flowLayout.setAlignment(FlowLayout.LEFT);
        flowLayout.setHgap(10);
        flowLayout.setVgap(10);
        panel.setLayout(flowLayout);
        renderAvailablePlayers(panel, gameState);
        this.getContentPane().add(panel);
        this.getContentPane().revalidate();
        this.getContentPane().repaint();

    }

    private void renderAvailablePlayers(JPanel panel, GameState gameState) {
        final List<Player> selectablePlayers = gameState.getPlayers().stream().filter(Player::isSelectable).sorted((o1, o2) -> {
            if (o1.getCount() == o2.getCount()) {
                return o1.getName().compareTo(o2.getName());
            } else if (o1.getCount() > o2.getCount()) {
                return -1;
            } else {
                return 1;
            }
        }).collect(Collectors.toList());
        renderAvailablePlayers(panel, selectablePlayers);
        final List<Player> deselectablePlayers = gameState.getPlayers().stream().filter(p -> !p.isSelectable()).sorted((o1, o2) -> {
            if (o1.getCount() == o2.getCount()) {
                return o1.getName().compareTo(o2.getName());
            } else if (o1.getCount() > o2.getCount()) {
                return -1;
            } else {
                return 1;
            }
        }).collect(Collectors.toList());
        renderAvailablePlayers(panel, deselectablePlayers);
    }

    private void renderAvailablePlayers(JPanel panel, List<Player> players) {
        for (int i = 0; i < players.size(); i++) {
            panel.add(createAvailablePlayerComponent(players.get(i), i, ((int) (Math.ceil(players.size() / 2d))) - 1));
        }
    }

    private Component createAvailablePlayerComponent(Player player, int index, int middleIndex) {
        final com.hvnis.swing.core.component.Panel panel = ComponentManager.getInstance().getComponentCreator().createPanel();
        final BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(boxlayout);
        panel.setBorder(new EmptyBorder(0, 0, 0, 0));
        panel.setPreferredSize(new Dimension(150, 200));

        // avatar
        final com.hvnis.swing.core.component.Panel avatarPanel = ComponentManager.getInstance().getComponentCreator().createPanel();

        BufferedImage img = null;
        try {
            img = ImageIO.read(new URL(player.getAvatar()));
        } catch (IOException e) {
            e.printStackTrace();
        }


        ImageIcon icon = null;
        if (img != null) {
            icon = new ImageIcon(img.getScaledInstance(100, 100, Image.SCALE_SMOOTH));
        }
        final JButton avatar = new JButton();
        avatar.setIcon(icon);
        avatar.setBorder(BorderFactory.createEmptyBorder());
        avatar.setHorizontalTextPosition(JButton.CENTER);
        avatar.setVerticalTextPosition(JButton.CENTER);
        avatar.setPreferredSize(new Dimension(100, 100));
        avatar.setBorder(BorderFactory.createEmptyBorder());
        avatar.setBackground(Color.BLUE);
        avatarPanel.setBorder(BorderFactory.createEmptyBorder());
        avatarPanel.add(avatar);

        // score
        final JLabel label = ComponentManager.getInstance().getComponentCreator().createLabel(player.getCount() + " - " + player.getName());
        label.setSize(150, 30);

        // Play button
        final com.hvnis.swing.core.component.Button btn = ComponentManager.getInstance().getComponentCreator().createButton();
        btn.setText("Play");
        btn.setPreferredSize(new Dimension(100, 30));

        if (PlayMode.UNLIMITED == playMode) {
            btn.addActionListener(new PlayMouseListener(this, player));
        } else {
            if (player.isPlayed()) {
                btn.setEnabled(false);
            } else {
                btn.addActionListener(new PlayMouseListener(this, player));
            }
        }

        final com.hvnis.swing.core.component.Panel namePanel = ComponentManager.getInstance().getComponentCreator().createPanel();
        namePanel.add(label);

        final com.hvnis.swing.core.component.Panel playPanel = ComponentManager.getInstance().getComponentCreator().createPanel();
        playPanel.add(btn);

        final com.hvnis.swing.core.component.Panel selectablePanel = ComponentManager.getInstance().getComponentCreator().createPanel();
        final CheckBox checkBox = ComponentManager.getInstance().getComponentCreator().createCheckBox();
        checkBox.setSelected(!player.isSelectable());
        checkBox.addItemListener(e -> {
            boolean isDisabled = e.getStateChange() == ItemEvent.SELECTED;
            player.setSelectable(!isDisabled);
            GamePlay.getInstance().setPlayerSelectable(player, !isDisabled);
//            renderContentPanel(GamePlay.getInstance().getCurrentGameState());
            decoratePanel(player, index, middleIndex, panel, avatarPanel, btn, namePanel, playPanel, selectablePanel);
        });
        selectablePanel.add(checkBox);

        decoratePanel(player, index, middleIndex, panel, avatarPanel, btn, namePanel, playPanel, selectablePanel);

        panel.add(avatarPanel);
        panel.add(namePanel);
        panel.add(playPanel);
        panel.add(selectablePanel);
        return panel;
    }

    private void decoratePanel(Player player, int index, int middleIndex, com.hvnis.swing.core.component.Panel panel,
                               com.hvnis.swing.core.component.Panel avatarPanel, com.hvnis.swing.core.component.Button btn,
                               com.hvnis.swing.core.component.Panel namePanel,
                               com.hvnis.swing.core.component.Panel playPanel,
                               com.hvnis.swing.core.component.Panel selectablePanel) {
        if (PlayMode.UNLIMITED == playMode) {
            btn.setEnabled(player.isSelectable());
        } else {
            btn.setEnabled(player.isSelectable() && !player.isPlayed());
        }
        if (player.isSelectable()) {
            Color color = Color.WHITE;
            if (index == 0 && index <= middleIndex) {
                color = Color.RED;
            } else if (index == 1 && index <= middleIndex) {
                color = Color.decode("#eb5f34");
            } else if (index == 2 && index <= middleIndex) {
                color = Color.PINK;
            } else if (index == 3 && index <= middleIndex) {
                color = Color.decode("#ebab34");
            } else if (index == 4 && index <= middleIndex) {
                color = Color.ORANGE;
            } else if (index == 5 && index <= middleIndex) {
                color = Color.YELLOW;
            }
            panel.setBackground(color);
            avatarPanel.setBackground(color);
        } else {
            panel.setBackground(Color.lightGray);
            avatarPanel.setBackground(Color.lightGray);
            namePanel.setBackground(Color.lightGray);
            playPanel.setBackground(Color.lightGray);
            selectablePanel.setBackground(Color.lightGray);
        }
    }
}
