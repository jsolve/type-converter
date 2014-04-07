package pl.jsolve.typeconverter.stringto;

public class StringToBooleanConverter extends StringToAbstractConverter<Boolean> {

	@Override
	public Boolean convert(String source) {
		return "TRUE".equals(source.trim().toUpperCase());
	}
}