package com.hvnis.swing.core.component;

import javax.swing.JRadioButton;

import com.hvnis.swing.theme.ITheme;

/**
 * @author hvnis
 */
public class RadioButton extends JRadioButton {
	private static final long serialVersionUID = 5112853310296459472L;

	public RadioButton(ITheme theme, String label) {
		super(label);
		setBackground(theme.getBackgroundColor());
		setForeground(theme.getForegroundColor());
		setFont(theme.getFont());
	}
}