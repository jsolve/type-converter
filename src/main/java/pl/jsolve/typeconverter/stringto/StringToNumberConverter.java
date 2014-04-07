package pl.jsolve.typeconverter.stringto;

import java.text.NumberFormat;
import java.text.ParseException;

import pl.jsolve.typeconverter.ConversionException;

public class StringToNumberConverter extends StringToAbstractConverter<Number> {

	@Override
	public Number convert(String source) {
		try {
			return NumberFormat.getNumberInstance().parse(source);
		} catch (ParseException e) {
			throw new ConversionException(String.class, Number.class, e);
		}
	}
}