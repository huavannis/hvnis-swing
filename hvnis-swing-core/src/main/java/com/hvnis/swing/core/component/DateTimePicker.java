package com.hvnis.swing.core.component;

import java.awt.Dimension;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.BorderFactory;

import org.jdatepicker.JDatePicker;
import org.jdatepicker.UtilDateModel;

import com.hvnis.swing.theme.ITheme;

import net.miginfocom.swing.MigLayout;

/**
 * @author hvnis
 */
public class DateTimePicker extends Panel {
	private static final long serialVersionUID = 18869354527871176L;
	private static final int DEFAULT_WIDTH = 25;
	public static final int HOUR_FIELD_INDEX = 1;
	public static final int MINUTE_FIELD_INDEX = 2;
	public static final int SECOND_FIELD_INDEX = 3;
	private UtilDateModel model;
	private JDatePicker datePicker;
	private NumberTextField hourTextField;
	private NumberTextField minuteTextField;
	private NumberTextField secondTextField;

	public DateTimePicker(ITheme theme, String dateFormat) {
		super(theme);
		setLayout(new MigLayout());
		setBorder(BorderFactory.createEmptyBorder(-5, -5, -5, -5));

		model = new UtilDateModel();
		datePicker = new JDatePicker(model, dateFormat);
		datePicker.setPreferredSize(new Dimension(120, datePicker.getHeight()));

		hourTextField = new NumberTextField(theme);
		minuteTextField = new NumberTextField(theme);
		secondTextField = new NumberTextField(theme);

		hourTextField.setPreferredSize(new Dimension(DEFAULT_WIDTH, hourTextField.getHeight()));
		minuteTextField.setPreferredSize(new Dimension(DEFAULT_WIDTH, minuteTextField.getHeight()));
		secondTextField.setPreferredSize(new Dimension(DEFAULT_WIDTH, secondTextField.getHeight()));

		add(datePicker);
		add(hourTextField);
		add(new Label(theme, ":"));
		add(minuteTextField);
		add(new Label(theme, ":"));
		add(secondTextField);
		setDate(new Date());
	}

	public void setDate(Date date) {
		model.setValue(date);
		Calendar calendar = createCalendar(date);
		hourTextField.setText(String.valueOf(calendar.get(11)));
		minuteTextField.setText(String.valueOf(calendar.get(12)));
		secondTextField.setText(String.valueOf(calendar.get(13)));
	}

	public Date getValue() {
		Date date = (Date) model.getValue();
		Calendar calendar = createCalendar(date);
		calendar.set(11, Integer.valueOf(hourTextField.getText()).intValue());
		calendar.set(12, Integer.valueOf(minuteTextField.getText()).intValue());
		calendar.set(13, Integer.valueOf(secondTextField.getText()).intValue());
		return calendar.getTime();
	}

	private Calendar createCalendar(Date date) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		return calendar;
	}

	public String getHourValue() {
		return hourTextField.getText();
	}

	public String getMinuteValue() {
		return minuteTextField.getText();
	}

	public String getSecondValue() {
		return secondTextField.getText();
	}

	public boolean isValidValue(int fieldIndex) {
		if (fieldIndex == HOUR_FIELD_INDEX) {
			return isValidValue(hourTextField);
		}
		if (fieldIndex == MINUTE_FIELD_INDEX) {
			return isValidValue(minuteTextField);
		}
		if (fieldIndex == SECOND_FIELD_INDEX) {
			return isValidValue(secondTextField);
		}
		return false;
	}

	private boolean isValidValue(TextField field) {
		try {
			Integer.parseInt(field.getText());
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
}