package com.hvnis.swing.core.component;

import javax.swing.Icon;

import com.hvnis.swing.theme.ITheme;

/**
 * @author hvnis
 */
public class ImageButton extends Button {
	private static final long serialVersionUID = 4149575919992319378L;

	public ImageButton(ITheme theme, Icon icon) {
		super(theme);
		setIcon(icon);
		setBackground(theme.getBackgroundColor());
		setBorder(null);
		setText(null);
	}
}