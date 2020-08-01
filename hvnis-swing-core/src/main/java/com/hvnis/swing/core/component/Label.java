package com.hvnis.swing.core.component;

import javax.swing.JLabel;

import com.hvnis.swing.theme.ITheme;

/**
 * @author hvnis
 */
public class Label extends JLabel {
	private static final long serialVersionUID = -2839563336973406838L;

	public Label(ITheme theme, String label) {
		super(label);
		setBackground(theme.getBackgroundColor());
		setForeground(theme.getForegroundColor());
		setFont(theme.getFont());
	}
}