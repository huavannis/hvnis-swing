package com.hvnis.swing.core.table.util;

import java.awt.Component;

import javax.swing.JTable;

import com.hvnis.swing.theme.ITheme;

/**
 * @author hvnis
 */
public final class TableUtil {
	public static void setRendererColor(Component component, ITheme theme, boolean isSelected, int row) {
		if (isSelected) {
			component.setBackground(theme.getActiveBackgroundColor());
			component.setForeground(theme.getActiveForegroundColor());
		} else if (row % 2 != 0) {
			component.setBackground(theme.getTableOddColor());
			component.setForeground(theme.getForegroundColor());
		} else {
			component.setBackground(theme.getBackgroundColor());
			component.setForeground(theme.getForegroundColor());
		}
	}

	public static int getColumnIndex(JTable table, String header) {
		for (int i = 0; i < table.getColumnCount(); i++) {
			if (table.getColumnName(i).equals(header)) {
				return i;
			}
		}
		return -1;
	}
}