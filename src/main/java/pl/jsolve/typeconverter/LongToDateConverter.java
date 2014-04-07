package pl.jsolve.typeconverter;

import java.util.Date;

public class LongToDateConverter implements Converter<Long, Date> {

	@Override
	public Date convert(Long source) {
		return new Date(source);
	}
}