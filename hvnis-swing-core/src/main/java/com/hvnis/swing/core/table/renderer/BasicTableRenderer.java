package com.hvnis.swing.core.table.renderer;

import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import com.hvnis.swing.core.table.BasicTable;
import com.hvnis.swing.core.table.util.TableUtil;
import com.hvnis.swing.theme.ITheme;

/**
 * @author hvnis
 */
public class BasicTableRenderer extends DefaultTableCellRenderer {
	private static final long serialVersionUID = -5642251681275454412L;
	private BasicTable basicTable;

	public BasicTableRenderer(BasicTable basicTable) {
		this.basicTable = basicTable;
	}

	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		ITheme theme = basicTable.getTheme();
		super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		table.setRowHeight(basicTable.getTableRowHeight());
		table.setGridColor(theme.getBorderColor());
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		TableUtil.setRendererColor(this, theme, isSelected, row);
		setFont(theme.getFont());
		return this;
	}
}