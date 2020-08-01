package com.hvnis.swing.core.filter;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.DocumentFilter;

/**
 * @author hvnis
 */
public class NumberFilter extends DocumentFilter {
	public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr)
			throws BadLocationException {
		Document doc = fb.getDocument();
		StringBuilder sb = new StringBuilder();
		sb.append(doc.getText(0, doc.getLength()));
		sb.insert(offset, string);
		if (isValid(sb.toString())) {
			super.insertString(fb, offset, string, attr);
		}
	}

	private boolean isValid(String text) {
		try {
			if ((text == null) || (text.trim().isEmpty())) {
				return true;
			}
			Integer.parseInt(text);
			return true;
		} catch (NumberFormatException e) {
		}
		return false;
	}

	public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
			throws BadLocationException {
		Document doc = fb.getDocument();
		StringBuilder sb = new StringBuilder();
		sb.append(doc.getText(0, doc.getLength()));
		sb.replace(offset, offset + length, text);
		if (isValid(sb.toString())) {
			super.replace(fb, offset, length, text, attrs);
		}
	}

	public void remove(FilterBypass fb, int offset, int length) throws BadLocationException {
		Document doc = fb.getDocument();
		StringBuilder sb = new StringBuilder();
		sb.append(doc.getText(0, doc.getLength()));
		sb.delete(offset, offset + length);
		if (isValid(sb.toString())) {
			super.remove(fb, offset, length);
		}
	}
}