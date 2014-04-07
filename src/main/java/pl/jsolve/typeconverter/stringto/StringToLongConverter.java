package pl.jsolve.typeconverter.stringto;


public class StringToLongConverter extends StringToAbstractConverter<Long> {

	@Override
	public Long convert(String source) {
		return Long.valueOf(source);
	}
}