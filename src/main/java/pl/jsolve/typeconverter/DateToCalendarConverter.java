package pl.jsolve.typeconverter;

import java.util.Calendar;
import java.util.Date;

public class DateToCalendarConverter implements Converter<Date, Calendar> {

	@Override
	public Calendar convert(Date source) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(source);
		return calendar;
	}
}