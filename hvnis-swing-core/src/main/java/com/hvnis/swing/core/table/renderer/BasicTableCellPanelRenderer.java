package com.hvnis.swing.core.table.renderer;

import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

import com.hvnis.swing.core.ComponentCreator;
import com.hvnis.swing.core.component.Panel;
import com.hvnis.swing.core.table.BasicTable;
import com.hvnis.swing.core.table.util.TableUtil;
import com.hvnis.swing.theme.ITheme;

/**
 * @author hvnis
 */
public class BasicTableCellPanelRenderer extends Panel implements TableCellRenderer {
	private static final long serialVersionUID = 5908086478701835702L;
	private BasicTable basicTable;

	public BasicTableCellPanelRenderer(BasicTable basicTable) {
		super(basicTable.getTheme());
		this.basicTable = basicTable;
	}

	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		ITheme theme = basicTable.getTheme();
		table.setRowHeight(basicTable.getTableRowHeight());
		table.setGridColor(theme.getBorderColor());
		setFont(theme.getFont());
		TableUtil.setRendererColor(this, theme, isSelected, row);
		add(createContent(theme, isSelected, row));
		return this;
	}

	protected Panel createContent(ITheme theme, boolean isSelected, int row) {
		Panel panel = new ComponentCreator(theme).createPanel();
		TableUtil.setRendererColor(panel, theme, isSelected, row);
		return panel;
	}
}