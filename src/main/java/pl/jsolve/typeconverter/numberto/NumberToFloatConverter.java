package pl.jsolve.typeconverter.numberto;



public class NumberToFloatConverter extends NumberToAbstractConverter<Float> {

	@Override
	public Float convert(Number source) {
		return source.floatValue();
	}
}