package com.hvnis.swing.core.component;

import java.awt.HeadlessException;

import javax.swing.JFrame;

import com.hvnis.swing.theme.ITheme;

/**
 * @author hvnis
 */
public class Frame extends JFrame {
	private static final long serialVersionUID = -5795213941485771754L;

	public Frame(ITheme theme, String title) throws HeadlessException {
		setTitle(title);
		setBackground(theme.getBackgroundColor());
		setForeground(theme.getForegroundColor());
		setFont(theme.getFont());
		getContentPane().setBackground(theme.getBackgroundColor());
		getContentPane().setForeground(theme.getForegroundColor());
		getContentPane().setFont(theme.getFont());
	}
}