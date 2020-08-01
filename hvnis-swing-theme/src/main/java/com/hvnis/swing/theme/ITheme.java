package com.hvnis.swing.theme;

import java.awt.Color;
import java.awt.Font;

/**
 * @author hvnis
 */
public abstract interface ITheme {
	public abstract Font getFont();

	public abstract Font getFontBold();

	public abstract Font getFontItalic();

	public abstract Color getMainBackgroundColor();

	public abstract Color getMainForegroundColor();

	public abstract Color getBackgroundColor();

	public abstract Color getForegroundColor();

	public abstract Color getDisabledBackgroundColor();

	public abstract Color getDisabledForegroundColor();

	public abstract Color getHighlightBackgroundColor();

	public abstract Color getHighlightForegroundColor();

	public abstract Color getActiveBackgroundColor();

	public abstract Color getActiveForegroundColor();

	public abstract Color getBorderColor();

	public abstract Color getTableOddColor();
}