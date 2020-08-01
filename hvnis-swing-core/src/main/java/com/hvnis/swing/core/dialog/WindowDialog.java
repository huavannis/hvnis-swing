package com.hvnis.swing.core.dialog;

import javax.swing.JDialog;

import com.hvnis.swing.core.component.Frame;
import com.hvnis.swing.theme.ITheme;

/**
 * @author hvnis
 */
public class WindowDialog extends JDialog {
	private static final long serialVersionUID = 7715328591810254884L;

	public WindowDialog(ITheme theme, Frame owner, String title, boolean modal) {
		super(owner, title, modal);
		init(theme);
	}

	public WindowDialog(ITheme theme, WindowDialog owner, String title, boolean modal) {
		super(owner, title, modal);
		init(theme);
	}

	private void init(ITheme theme) {
		setBackground(theme.getBackgroundColor());
		setForeground(theme.getForegroundColor());
		setFont(theme.getFont());
		getContentPane().setBackground(theme.getBackgroundColor());
		getContentPane().setForeground(theme.getForegroundColor());
		getContentPane().setFont(theme.getFont());
	}
}