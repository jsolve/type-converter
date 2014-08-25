package pl.jsolve.typeconverter.enumto;

import pl.jsolve.typeconverter.Converter;

public class EnumToStringConverter<T extends  Enum<T>> implements Converter<T, String>{

	@Override
	public String convert(T source) {
		return source.name();
	}
}
