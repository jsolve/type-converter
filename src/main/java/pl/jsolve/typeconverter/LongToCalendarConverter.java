package pl.jsolve.typeconverter;

import java.util.Calendar;

public class LongToCalendarConverter implements Converter<Long, Calendar> {

	@Override
	public Calendar convert(Long source) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(source);
		return calendar;
	}
}