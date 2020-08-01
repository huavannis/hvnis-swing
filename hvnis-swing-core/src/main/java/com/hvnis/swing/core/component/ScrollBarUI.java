package com.hvnis.swing.core.component;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JScrollBar;
import javax.swing.plaf.basic.BasicScrollBarUI;

/**
 * @author hvnis
 */
class ScrollBarUI extends BasicScrollBarUI {
	private static final int DEFAULT_SCROLL_BAR_WIDTH = 7;
	private int width;

	public ScrollBarUI(ScrollPane scroll) {
		this(scroll, DEFAULT_SCROLL_BAR_WIDTH);
	}

	public ScrollBarUI(ScrollPane scroll, int width) {
		this.width = width;
		scroll.setBorder(BorderFactory.createEmptyBorder());
		scroll.getVerticalScrollBar().setSize(width, scroll.getVerticalScrollBar().getHeight());
		scroll.getVerticalScrollBar().setPreferredSize(new Dimension(width, scroll.getVerticalScrollBar().getHeight()));
		scroll.getVerticalScrollBar().setBackground(Color.WHITE);
		scroll.getVerticalScrollBar().setUnitIncrement(10);
		scroll.getHorizontalScrollBar().setSize(scroll.getHorizontalScrollBar().getWidth(), width);
		scroll.getHorizontalScrollBar()
				.setPreferredSize(new Dimension(scroll.getHorizontalScrollBar().getWidth(), width));
		scroll.getHorizontalScrollBar().setBackground(Color.BLACK);
		scroll.getHorizontalScrollBar().setUnitIncrement(10);
	}

	protected JButton createDecreaseButton(int orientation) {
		return createZeroButton();
	}

	protected JButton createIncreaseButton(int orientation) {
		return createZeroButton();
	}

	private JButton createZeroButton() {
		JButton jbutton = new JButton();
		jbutton.setPreferredSize(new Dimension(0, 0));
		jbutton.setMinimumSize(new Dimension(0, 0));
		jbutton.setMaximumSize(new Dimension(0, 0));
		return jbutton;
	}

	protected void paintThumb(Graphics g, JComponent c, Rectangle r) {
		Graphics2D g2 = (Graphics2D) g.create();
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		Color color = null;
		JScrollBar sb = (JScrollBar) c;
		if ((r.isEmpty()) || (!sb.isEnabled())) {
			return;
		}
		if (isDragging) {
			color = Color.DARK_GRAY;
		} else if (isThumbRollover()) {
			color = Color.DARK_GRAY;
		} else {
			color = Color.GRAY;
		}
		Rectangle thumbBounds = getThumbBounds();
		g2.translate(thumbBounds.x, thumbBounds.y);
		g2.setPaint(color);
		g2.fillRoundRect(0, 0, width, thumbBounds.height, 10, 10);
		g2.setPaint(Color.GRAY);
		g2.drawRoundRect(0, 0, width, thumbBounds.height, 10, 10);
		g2.translate(-thumbBounds.x, -thumbBounds.y);
		g2.dispose();
	}

	protected void setThumbBounds(int x, int y, int width, int height) {
		super.setThumbBounds(x, y, width, height);
		scrollbar.repaint();
	}

	public void paint(Graphics g, JComponent c) {
		super.paint(g, c);
	}

	public int getWidth() {
		return width;
	}
}