package com.hvnis.swing.core.component;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JButton;

import com.hvnis.swing.theme.ITheme;

/**
 * @author hvnis
 */
public class Button extends JButton {
	private static final long serialVersionUID = 6364454141179749801L;
	private Color backgroundColor;
	private Color foregroundColor;
	private Color disabledBackgroundColor;
	private Color disabledForegroundColor;
	private int height = 25;

	public Button(ITheme theme) {
		init(theme);
	}

	public Button(ITheme theme, Action a) {
		super(a);
		init(theme);
	}

	public Button(ITheme theme, Icon icon) {
		super(icon);
		init(theme);
	}

	public Button(ITheme theme, String text, Icon icon) {
		super(text, icon);
		init(theme);
	}

	public Button(ITheme theme, String text) {
		super(text);
		init(theme);
	}

	private void init(ITheme theme) {
		backgroundColor = theme.getMainBackgroundColor();
		foregroundColor = theme.getMainForegroundColor();
		disabledBackgroundColor = theme.getDisabledBackgroundColor();
		disabledForegroundColor = theme.getDisabledForegroundColor();
		setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1),
				new CustomBorder(this)));
		setContentAreaFilled(false);
		setFocusPainted(false);
		setFont(theme.getFont());
		setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g.create();
		if (isEnabled()) {
			g2.setPaint(
					new GradientPaint(new Point(0, 0), backgroundColor, new Point(0, getHeight()), backgroundColor));
			super.setForeground(foregroundColor);
		} else {
			g2.setPaint(new GradientPaint(new Point(0, 0), disabledBackgroundColor, new Point(0, getHeight()),
					disabledBackgroundColor));
			super.setForeground(disabledForegroundColor);
		}
		g2.fillRect(0, 0, getWidth(), getHeight());
		g2.dispose();
		super.paintComponent(g);
	}

	@Override
	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void setBackground(Color color) {
		super.setBackground(color);
		backgroundColor = color;
	}

	public void setForeground(Color color) {
		super.setForeground(color);
		foregroundColor = color;
	}

	public Color getBackgroundColor() {
		return backgroundColor;
	}

	public Color getForegroundColor() {
		return foregroundColor;
	}
}
