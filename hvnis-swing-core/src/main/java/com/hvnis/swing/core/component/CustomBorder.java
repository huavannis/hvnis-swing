package com.hvnis.swing.core.component;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;

import javax.swing.border.AbstractBorder;

/**
 * @author hvnis
 */
class CustomBorder extends AbstractBorder {
	private static final long serialVersionUID = 429736786606716853L;
	private static final int DEFAULT_PADDING_TOP = 5;
	private static final int DEFAULT_PADDING_BOTTOM = 5;
	private static final int DEFAULT_PADDING_LEFT = 10;
	private static final int DEFAULT_PADDING_RIGHT = 10;
	private Button customButton;

	public CustomBorder(Button customButton) {
		this.customButton = customButton;
	}

	public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
		((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(getBorderColor());
		g.drawRect(x, y, width, height);
	}

	public Insets getBorderInsets(Component c) {
		return new Insets(DEFAULT_PADDING_TOP, DEFAULT_PADDING_LEFT, DEFAULT_PADDING_BOTTOM, DEFAULT_PADDING_RIGHT);
	}

	public Insets getBorderInsets(Component c, Insets insets) {
		insets.left = DEFAULT_PADDING_LEFT;
		insets.top = DEFAULT_PADDING_TOP;
		insets.right = DEFAULT_PADDING_RIGHT;
		insets.bottom = DEFAULT_PADDING_BOTTOM;
		return insets;
	}

	public Color getBorderColor() {
		return customButton.getBackgroundColor();
	}
}