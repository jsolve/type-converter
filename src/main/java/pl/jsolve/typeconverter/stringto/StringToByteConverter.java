package pl.jsolve.typeconverter.stringto;


public class StringToByteConverter extends StringToAbstractConverter<Byte> {

	@Override
	public Byte convert(String source) {
		return Byte.valueOf(source);
	}
}