package pl.jsolve.typeconverter.stringto;

import java.math.BigInteger;

public class StringToBigIntegerConverter extends StringToAbstractConverter<BigInteger> {

	@Override
	public BigInteger convert(String source) {
		return new BigInteger(source);
	}
}