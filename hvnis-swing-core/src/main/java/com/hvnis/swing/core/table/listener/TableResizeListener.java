package com.hvnis.swing.core.table.listener;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JTable;

import com.hvnis.swing.core.table.model.TableColumns;

/**
 * @author hvnis
 */
public class TableResizeListener extends ComponentAdapter {
	private JTable table;
	private TableColumns tableColumns;

	public TableResizeListener(JTable table, TableColumns tableColumns) {
		this.table = table;
		this.tableColumns = tableColumns;
	}

	public void componentResized(ComponentEvent e) {
		int tableWidth = table.getWidth();
		com.hvnis.swing.core.table.model.TableColumn[] columns = tableColumns.getColumns();
		for (int i = 0; i < columns.length; i++) {
			com.hvnis.swing.core.table.model.TableColumn column = columns[i];
			switch (tableColumns.getType()) {
			case DEFAULT:
				table.getColumnModel().getColumn(i).setPreferredWidth(column.getValue());
				break;
			case PERCENT:
				table.getColumnModel().getColumn(i).setPreferredWidth(Math.round(column.getValue() * tableWidth / 100));
			}
		}
	}
}