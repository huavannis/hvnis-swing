package com.hvnis.swing.ranoffee;

import javax.swing.*;
import java.awt.*;

public class Application {

    public static void main(String[] args) {
        final int width = 670;
        final int height = 680;
        final Home home = new Home(PlayMode.LIMITED);
        home.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        home.setSize(width, height);
        home.setTitle("Random Coffee");
        home.setAlwaysOnTop(true);
        home.toFront();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        home.setLocation(dim.width / 2 - width / 2, dim.height / 2 - height / 2);
        home.setVisible(true);

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
