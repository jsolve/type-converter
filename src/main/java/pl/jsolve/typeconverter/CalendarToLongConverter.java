package pl.jsolve.typeconverter;

import java.util.Calendar;

public class CalendarToLongConverter implements Converter<Calendar, Long> {

	@Override
	public Long convert(Calendar source) {
		return source.getTimeInMillis();
	}
}