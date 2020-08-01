package com.hvnis.swing.theme.impl;

import java.awt.Color;

/**
 * @author hvnis
 */
public class BlueTheme extends AbstractTheme {
	public Color getMainBackgroundColor() {
		return new Color(31, 110, 146);
	}

	public Color getMainForegroundColor() {
		return Color.WHITE;
	}

	public Color getHighlightBackgroundColor() {
		return new Color(239, 241, 244);
	}

	public Color getHighlightForegroundColor() {
		return Color.BLACK;
	}

	public Color getActiveBackgroundColor() {
		return new Color(187, 210, 240);
	}

	public Color getActiveForegroundColor() {
		return Color.BLACK;
	}
}