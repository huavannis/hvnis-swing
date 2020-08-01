package com.hvnis.swing.theme.impl;

import com.hvnis.swing.theme.ITheme;
import java.awt.Color;
import java.awt.Font;

/**
 * @author hvnis
 */
public abstract class AbstractTheme implements ITheme {
	public Font getFont() {
		return new Font("Arial", 0, 13);
	}

	public Font getFontBold() {
		return new Font("Arial", 1, 13);
	}

	public Font getFontItalic() {
		return new Font("Arial", 2, 13);
	}

	public Color getBackgroundColor() {
		return Color.WHITE;
	}

	public Color getForegroundColor() {
		return Color.BLACK;
	}

	public Color getDisabledBackgroundColor() {
		return Color.LIGHT_GRAY;
	}

	public Color getDisabledForegroundColor() {
		return Color.WHITE;
	}

	public Color getBorderColor() {
		return Color.LIGHT_GRAY;
	}

	public Color getTableOddColor() {
		return new Color(250, 250, 250);
	}
}