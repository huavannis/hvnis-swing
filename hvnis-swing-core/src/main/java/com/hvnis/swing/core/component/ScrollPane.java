package com.hvnis.swing.core.component;

import javax.swing.JScrollPane;

import com.hvnis.swing.theme.ITheme;

/**
 * @author hvnis
 */
public class ScrollPane extends JScrollPane {
	private static final long serialVersionUID = 7123504881851024953L;

	public ScrollPane(ITheme theme) {
		getVerticalScrollBar().setUI(new ScrollBarUI(this));
		getHorizontalScrollBar().setUI(new ScrollBarUI(this));
		setBackground(theme.getBackgroundColor());
		setForeground(theme.getForegroundColor());
		setFont(theme.getFont());
		getViewport().setBackground(theme.getBackgroundColor());
		getViewport().setForeground(theme.getForegroundColor());
		getViewport().setFont(theme.getFont());
	}
}