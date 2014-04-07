package pl.jsolve.typeconverter.stringto;

import java.math.BigDecimal;

public class StringToBigDecimalConverter extends StringToAbstractConverter<BigDecimal> {

	@Override
	public BigDecimal convert(String source) {
		return BigDecimal.valueOf(Double.valueOf(source));
	}
}