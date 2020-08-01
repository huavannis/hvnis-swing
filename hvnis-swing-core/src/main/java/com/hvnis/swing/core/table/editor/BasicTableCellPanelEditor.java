package com.hvnis.swing.core.table.editor;

import java.awt.Component;

import javax.swing.DefaultCellEditor;
import javax.swing.JTable;

import com.hvnis.swing.core.ComponentCreator;
import com.hvnis.swing.core.component.CheckBox;
import com.hvnis.swing.core.component.Panel;
import com.hvnis.swing.core.table.util.TableUtil;
import com.hvnis.swing.theme.ITheme;

/**
 * @author hvnis
 */
public class BasicTableCellPanelEditor extends DefaultCellEditor {
	private static final long serialVersionUID = 2615964032965916335L;
	private ITheme theme;

	public BasicTableCellPanelEditor(ITheme theme) {
		super(new CheckBox(theme));
		this.theme = theme;
	}

	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		return createContent(theme, isSelected, row);
	}

	protected Panel createContent(ITheme theme, boolean isSelected, int row) {
		Panel panel = new ComponentCreator(theme).createPanel();
		TableUtil.setRendererColor(panel, theme, isSelected, row);
		return panel;
	}
}