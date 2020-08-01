package com.hvnis.swing.core.component;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import com.hvnis.swing.theme.ITheme;

/**
 * @author hvnis
 */
public class ImagePanel extends Panel {
	private static final long serialVersionUID = -5479985725595541180L;
	private Image backgroundImage;
	private boolean scale;

	public ImagePanel(ITheme theme, String imageFilePath, boolean scale) {
		super(theme);
		backgroundImage = new ImageIcon(imageFilePath).getImage();
		this.scale = scale;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (scale) {
			g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
		} else {
			g.drawImage(backgroundImage, 0, 0, this);
		}
	}
}