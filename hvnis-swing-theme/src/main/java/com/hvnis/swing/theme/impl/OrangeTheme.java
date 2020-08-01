package com.hvnis.swing.theme.impl;

import java.awt.Color;

/**
 * @author hvnis
 */
public class OrangeTheme extends AbstractTheme {
	public Color getMainBackgroundColor() {
		return new Color(230, 123, 16);
	}

	public Color getMainForegroundColor() {
		return Color.WHITE;
	}

	public Color getHighlightBackgroundColor() {
		return new Color(249, 237, 169);
	}

	public Color getHighlightForegroundColor() {
		return Color.BLACK;
	}

	public Color getActiveBackgroundColor() {
		return new Color(247, 215, 145);
	}

	public Color getActiveForegroundColor() {
		return Color.BLACK;
	}
}