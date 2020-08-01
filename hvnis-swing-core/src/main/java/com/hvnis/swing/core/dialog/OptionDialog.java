package com.hvnis.swing.core.dialog;

import java.awt.Component;

import javax.swing.Icon;
import javax.swing.JOptionPane;

/**
 * @author hvnis
 */
public class OptionDialog {
	private Component component;
	private String title;
	private String message;
	private int option;
	private int type;
	private Object[] labels;
	private Icon icon;
	private int status;

	public OptionDialog(Component component, String title, String message, int option, int type, Object[] labels,
			Icon icon) {
		this.component = component;
		this.title = title;
		this.message = message;
		this.option = option;
		this.type = type;
		this.labels = labels;
		this.icon = icon;
		status = 1;
	}

	public void show() {
		if (labels != null) {
			status = JOptionPane.showOptionDialog(component, message, title, option, type, icon, labels, labels[0]);
		} else {
			status = JOptionPane.showConfirmDialog(component, message, title, option, type);
		}
	}

	public boolean accept() {
		return status == 0;
	}
}