package com.hvnis.swing.core.component;

import javax.swing.JTabbedPane;

import com.hvnis.swing.theme.ITheme;

/**
 * @author hvnis
 */
public class TabPane extends JTabbedPane {
	private static final long serialVersionUID = -3933708428950718212L;

	public TabPane(ITheme theme) {
		setFocusable(false);
		setBackground(theme.getBackgroundColor());
		setForeground(theme.getForegroundColor());
		setFont(theme.getFont());
	}
}