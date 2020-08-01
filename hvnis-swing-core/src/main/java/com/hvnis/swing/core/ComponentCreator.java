package com.hvnis.swing.core;

import javax.swing.Icon;

import com.hvnis.swing.core.component.Button;
import com.hvnis.swing.core.component.CheckBox;
import com.hvnis.swing.core.component.DatePicker;
import com.hvnis.swing.core.component.DateTimePicker;
import com.hvnis.swing.core.component.Frame;
import com.hvnis.swing.core.component.GroupBox;
import com.hvnis.swing.core.component.ImageButton;
import com.hvnis.swing.core.component.ImagePanel;
import com.hvnis.swing.core.component.Label;
import com.hvnis.swing.core.component.NumberTextField;
import com.hvnis.swing.core.component.Panel;
import com.hvnis.swing.core.component.RadioButton;
import com.hvnis.swing.core.component.RadioButtonGroup;
import com.hvnis.swing.core.component.ScrollPane;
import com.hvnis.swing.core.component.TabPane;
import com.hvnis.swing.core.component.TextArea;
import com.hvnis.swing.core.component.TextField;
import com.hvnis.swing.core.dialog.OptionDialog;
import com.hvnis.swing.core.dialog.WindowDialog;
import com.hvnis.swing.core.table.BasicTable;
import com.hvnis.swing.core.table.model.TableColumns;
import com.hvnis.swing.theme.ITheme;

/**
 * @author hvnis
 */
public class ComponentCreator {
	private ITheme theme;

	public ComponentCreator(ITheme theme) {
		this.theme = theme;
	}

	public Panel createPanel() {
		return new Panel(theme);
	}

	public ImagePanel createImagePanel(String imageFilePath, boolean scale) {
		return new ImagePanel(theme, imageFilePath, scale);
	}

	public TabPane createTabPane() {
		return new TabPane(theme);
	}

	public Button createButton(String label) {
		return new Button(theme, label);
	}

	public RadioButton createRadioButton(String label) {
		return new RadioButton(theme, label);
	}

	public RadioButtonGroup createRadioButtonGroup() {
		return new RadioButtonGroup();
	}

	public ImageButton createImageButton(Icon icon) {
		return new ImageButton(theme, icon);
	}

	public Label createLabel(String label) {
		return new Label(theme, label);
	}

	public BasicTable createBasicTable(TableColumns tableColumns) {
		return new BasicTable(theme, tableColumns);
	}

	public ScrollPane createScrollPane() {
		return new ScrollPane(theme);
	}

	public Frame createFrame(String title) {
		return new Frame(theme, title);
	}

	public OptionDialog createOptionDialog(Frame frame, String title, String message, int option, int type,
			Object[] labels, Icon icon) {
		return new OptionDialog(frame, title, message, option, type, labels, icon);
	}

	public WindowDialog createWindowDialog(Frame owner, String title, boolean modal) {
		return new WindowDialog(theme, owner, title, modal);
	}

	public WindowDialog createWindowDialog(WindowDialog owner, String title, boolean modal) {
		return new WindowDialog(theme, owner, title, modal);
	}

	public GroupBox createGroupBox(String title, boolean bold) {
		return new GroupBox(theme, title, bold);
	}

	public TextField createTextField() {
		return new TextField(theme);
	}

	public NumberTextField createNumberTextField() {
		return new NumberTextField(theme);
	}

	public TextArea createTextArea(int rows, int cols) {
		return new TextArea(theme, rows, cols);
	}

	public DateTimePicker createDateTimePicker(String dateFormat) {
		return new DateTimePicker(theme, dateFormat);
	}

	public DatePicker createDatePicker(String dateFormat) {
		return new DatePicker(theme, dateFormat);
	}

	public CheckBox createCheckBox() {
		return new CheckBox(theme);
	}
}