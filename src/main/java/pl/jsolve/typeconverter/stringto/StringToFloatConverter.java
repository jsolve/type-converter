package pl.jsolve.typeconverter.stringto;


public class StringToFloatConverter extends StringToAbstractConverter<Float> {

	@Override
	public Float convert(String source) {
		return Float.valueOf(source);
	}
}