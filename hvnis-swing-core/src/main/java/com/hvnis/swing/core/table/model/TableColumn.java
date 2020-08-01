package com.hvnis.swing.core.table.model;

/**
 * @author hvnis
 */
public class TableColumn {
	private String title;
	private int value;

	public TableColumn(String title, int value) {
		this.title = title;
		this.value = value;
	}

	public String getTitle() {
		return title;
	}

	public int getValue() {
		return value;
	}
}