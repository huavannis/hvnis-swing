package com.hvnis.swing.core.component;

import javax.swing.text.PlainDocument;

import com.hvnis.swing.core.filter.NumberFilter;
import com.hvnis.swing.theme.ITheme;

/**
 * @author hvnis
 */
public class NumberTextField extends TextField {
	private static final long serialVersionUID = -3636436279330561892L;

	public NumberTextField(ITheme theme) {
		super(theme);
		PlainDocument doc = (PlainDocument) getDocument();
		doc.setDocumentFilter(new NumberFilter());
	}
}