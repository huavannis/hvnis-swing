package com.hvnis.swing.core.component;

import javax.swing.JTextField;

import com.hvnis.swing.theme.ITheme;

/**
 * @author hvnis
 */
public class TextField extends JTextField {
	private static final long serialVersionUID = 7053497301042496745L;

	public TextField(ITheme theme) {
		setBackground(theme.getBackgroundColor());
		setForeground(theme.getForegroundColor());
		setFont(theme.getFont());
		setDisabledTextColor(theme.getDisabledForegroundColor());
	}
}