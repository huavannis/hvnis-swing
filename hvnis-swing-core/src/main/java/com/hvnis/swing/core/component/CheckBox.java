package com.hvnis.swing.core.component;

import javax.swing.JCheckBox;

import com.hvnis.swing.theme.ITheme;

/**
 * @author hvnis
 */
public class CheckBox extends JCheckBox {
	private static final long serialVersionUID = 817209122374851698L;

	public CheckBox(ITheme theme) {
		setBackground(theme.getBackgroundColor());
		setForeground(theme.getForegroundColor());
		setFont(theme.getFont());
	}
}