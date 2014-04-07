package pl.jsolve.typeconverter.numberto;



public class NumberToIntegerConverter extends NumberToAbstractConverter<Integer> {

	@Override
	public Integer convert(Number source) {
		return source.intValue();
	}
}