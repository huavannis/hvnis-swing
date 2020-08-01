package com.hvnis.swing.core.table.model;

/**
 * @author hvnis
 */
public class TableColumns {
	private Type type;
	private TableColumn[] columns;

	public static enum Type {
		DEFAULT, PERCENT;
	}

	public TableColumns(Type type, TableColumn[] columns) {
		this.type = type;
		this.columns = columns;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public TableColumn[] getColumns() {
		return columns;
	}

	public void setColumns(TableColumn[] columns) {
		this.columns = columns;
	}
}