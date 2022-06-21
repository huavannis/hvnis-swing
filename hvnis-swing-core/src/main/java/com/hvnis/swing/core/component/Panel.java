package com.hvnis.swing.core.component;

import javax.swing.JPanel;

import com.hvnis.swing.theme.ITheme;

/**
 * @author hvnis
 */
public class Panel extends JPanel {
	private static final long serialVersionUID = 8949264976011697185L;

	public Panel(ITheme theme) {
		super();
		setBackground(theme.getBackgroundColor());
		setForeground(theme.getForegroundColor());
		setFont(theme.getFont());
	}
}