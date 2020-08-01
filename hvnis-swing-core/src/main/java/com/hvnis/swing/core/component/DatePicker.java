package com.hvnis.swing.core.component;

import java.awt.Dimension;
import java.util.Date;

import javax.swing.BorderFactory;

import org.jdatepicker.JDatePicker;
import org.jdatepicker.UtilDateModel;

import com.hvnis.swing.theme.ITheme;

import net.miginfocom.swing.MigLayout;

/**
 * @author hvnis
 */
public class DatePicker extends Panel {
	private static final long serialVersionUID = 7546845052499996505L;
	private UtilDateModel model;
	private JDatePicker datePicker;

	public DatePicker(ITheme theme, String dateFormat) {
		super(theme);
		setLayout(new MigLayout());
		setBorder(BorderFactory.createEmptyBorder(-5, -5, -5, -5));

		model = new UtilDateModel();
		datePicker = new JDatePicker(model, dateFormat);
		datePicker.setPreferredSize(new Dimension(120, datePicker.getHeight()));

		add(datePicker);
		setDate(new Date());
	}

	public void setDate(Date date) {
		model.setValue(date);
	}

	public Date getValue() {
		return (Date) model.getValue();
	}
}