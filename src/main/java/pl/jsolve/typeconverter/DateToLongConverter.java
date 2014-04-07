package pl.jsolve.typeconverter;

import java.util.Date;

public class DateToLongConverter implements Converter<Date, Long> {

	@Override
	public Long convert(Date source) {
		return source.getTime();
	}
}