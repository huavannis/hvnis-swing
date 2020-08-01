package com.hvnis.swing.core.table.model;

import javax.swing.table.DefaultTableModel;

/**
 * @author hvnis
 */
public class TableModel extends DefaultTableModel {
	private static final long serialVersionUID = 3270556731970026989L;

	public TableModel(TableColumns tableColumns) {
		super(new Object[0][], getColumnTitles(tableColumns));
	}

	private static String[] getColumnTitles(TableColumns tableColumns) {
		TableColumn[] columns = tableColumns.getColumns();
		String[] titles = new String[columns.length];
		for (int i = 0; i < columns.length; i++) {
			titles[i] = columns[i].getTitle();
		}
		return titles;
	}
}