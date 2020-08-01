package com.hvnis.swing.core.component;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;

/**
 * @author hvnis
 */
public class RadioButtonGroup extends ButtonGroup {
	private static final long serialVersionUID = -1291102639798290468L;
	private List<RadioButton> childs = new ArrayList<>();

	public List<RadioButton> getChilds() {
		return childs;
	}

	public void setChilds(List<RadioButton> childs) {
		this.childs = childs;
	}

	public void setSelectedElement(RadioButton element) {
		for (RadioButton child : childs) {
			if (child.equals(element)) {
				child.setSelected(true);
			} else {
				child.setSelected(false);
			}
		}
	}

	public void setSelectedElement(String label) {
		setSelectedElement(getRadioButtonByLabel(label));
	}

	public void addElement(RadioButton element) {
		if ((element != null) && (!childs.contains(element))) {
			element.setSelected(false);
			childs.add(element);
			add(element);
		}
	}

	public void removeAllElements() {
		for (RadioButton element : childs) {
			remove(element);
		}
		childs.clear();
	}

	public RadioButton getSelectedElement() {
		for (RadioButton element : childs) {
			if (isSelected(element.getModel())) {
				return element;
			}
		}
		return null;
	}

	public RadioButton getRadioButtonByLabel(String label) {
		for (RadioButton element : childs) {
			if (element.getText().equals(label)) {
				return element;
			}
		}
		return null;
	}

	public void enabledAll(boolean enabled) {
		for (RadioButton element : childs) {
			element.setEnabled(enabled);
		}
	}

	public void enabled(String label, boolean enabled) {
		for (RadioButton element : childs) {
			if (element.getText().equals(label)) {
				element.setEnabled(enabled);
			}
		}
	}
}