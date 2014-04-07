package pl.jsolve.typeconverter.numberto;

import java.math.BigDecimal;

public class NumberToBigDecimalConverter extends NumberToAbstractConverter<BigDecimal> {

	@Override
	public BigDecimal convert(Number source) {
		return new BigDecimal(source.toString());
	}
}