package pl.jsolve.typeconverter;

import java.util.Calendar;
import java.util.Date;

public class CalendarToDateConverter implements Converter<Calendar, Date> {

	@Override
	public Date convert(Calendar source) {
		return source.getTime();
	}
}