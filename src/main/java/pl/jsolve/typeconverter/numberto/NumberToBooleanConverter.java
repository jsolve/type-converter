package pl.jsolve.typeconverter.numberto;



public class NumberToBooleanConverter extends NumberToAbstractConverter<Boolean> {

	@Override
	public Boolean convert(Number source) {
		return source.intValue() == 0 ? Boolean.FALSE : Boolean.TRUE;
	}
}