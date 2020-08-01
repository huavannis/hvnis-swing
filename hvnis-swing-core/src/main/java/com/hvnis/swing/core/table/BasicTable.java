package com.hvnis.swing.core.table;

import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

import com.hvnis.swing.core.table.listener.TableResizeListener;
import com.hvnis.swing.core.table.model.TableColumns;
import com.hvnis.swing.core.table.model.TableModel;
import com.hvnis.swing.core.table.renderer.BasicTableRenderer;
import com.hvnis.swing.theme.ITheme;

/**
 * @author hvnis
 */
public class BasicTable extends JTable {
	private static final long serialVersionUID = -3229040816543353541L;
	private int tableHeaderHeight = 25;
	private int tableRowHeight = 25;
	private ITheme theme;
	TableColumns tableColumns;

	public BasicTable(ITheme theme, TableColumns tableColumns) {
		this.theme = theme;
		this.tableColumns = tableColumns;
		init();
	}

	private void init() {
		setAutoResizeMode(3);
		setSelectionMode(0);
		setBorder(BorderFactory.createLineBorder(theme.getBorderColor()));
		setFillsViewportHeight(true);
		setCursor(new Cursor(12));
		setDefaultRenderer(Object.class, new BasicTableRenderer(this));
		setBackground(theme.getBackgroundColor());
		setForeground(theme.getForegroundColor());
		setFont(theme.getFontBold());
		formatHeader();
		setModel(new TableModel(tableColumns));
		addComponentListener(new TableResizeListener(this, tableColumns));
	}

	private void formatHeader() {
		JTableHeader tableHeader = getTableHeader();
		TableCellRenderer rendererFromHeader = tableHeader.getDefaultRenderer();
		JLabel headerLabel = (JLabel) rendererFromHeader;
		headerLabel.setHorizontalAlignment(2);
		tableHeader.setOpaque(false);
		tableHeader.setBackground(theme.getMainBackgroundColor());
		tableHeader.setForeground(theme.getMainForegroundColor());
		tableHeader.setFont(theme.getFontBold());
		setTableHeaderHeight(tableHeaderHeight);
	}

	public ITheme getTheme() {
		return theme;
	}

	public int getTableHeaderHeight() {
		return tableHeaderHeight;
	}

	public void setTableHeaderHeight(int tableHeaderHeight) {
		this.tableHeaderHeight = tableHeaderHeight;
		tableHeader.setPreferredSize(new Dimension(tableHeader.getWidth(), tableHeaderHeight));
	}

	public int getTableRowHeight() {
		return tableRowHeight;
	}

	public void setTableRowHeight(int tableRowHeight) {
		this.tableRowHeight = tableRowHeight;
		setRowHeight(tableRowHeight);
	}

	public void clear() {
		DefaultTableModel model = (DefaultTableModel) getModel();
		while (model.getRowCount() > 0) {
			model.removeRow(0);
		}
		clearSelection();
	}

	public javax.swing.table.TableColumn getColumn(com.hvnis.swing.core.table.model.TableColumn tableColumn) {
		return getColumn(tableColumn.getTitle());
	}

	public int getColumnIndex(com.hvnis.swing.core.table.model.TableColumn tableColumn) {
		return getTableHeader().getColumnModel().getColumnIndex(tableColumn.getTitle());
	}
}