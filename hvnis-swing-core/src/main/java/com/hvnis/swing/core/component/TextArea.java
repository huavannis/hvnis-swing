package com.hvnis.swing.core.component;

import javax.swing.BorderFactory;
import javax.swing.JTextArea;

import com.hvnis.swing.theme.ITheme;

/**
 * @author hvnis
 */
public class TextArea extends JTextArea {
	private static final long serialVersionUID = 7218268703936444070L;

	public TextArea(ITheme theme, int rows, int cols) {
		super(rows, cols);
		setBorder(BorderFactory.createLineBorder(theme.getBorderColor()));
		setBackground(theme.getBackgroundColor());
		setForeground(theme.getForegroundColor());
		setFont(theme.getFont());
	}
}