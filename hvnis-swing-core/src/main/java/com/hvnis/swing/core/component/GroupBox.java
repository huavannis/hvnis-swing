package com.hvnis.swing.core.component;

import javax.swing.BorderFactory;
import javax.swing.border.TitledBorder;

import com.hvnis.swing.theme.ITheme;

/**
 * @author hvnis
 */
public class GroupBox extends Panel {
	private static final long serialVersionUID = 5394012099433746290L;

	public GroupBox(ITheme theme, String title, boolean bold) {
		super(theme);
		TitledBorder border = BorderFactory.createTitledBorder(title);
		border.setTitleFont(bold ? theme.getFontBold() : theme.getFont());
		setBorder(border);
	}
}