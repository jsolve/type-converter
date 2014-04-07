package pl.jsolve.typeconverter.stringto;


public class StringToIntegerConverter extends StringToAbstractConverter<Integer> {

	@Override
	public Integer convert(String source) {
		return Integer.parseInt(source);
	}
}