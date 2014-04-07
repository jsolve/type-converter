package pl.jsolve.typeconverter;

import static org.fest.assertions.Assertions.assertThat;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.junit.Test;

public class NumberToStringConversionTest {
	
	@Test
	public void shouldConvertBigIntegerToString() {
		// when
		String result = TypeConverter.convert(BigInteger.ONE, String.class);

		// then
		assertThat(result).isEqualTo("1");
	}

	@Test
	public void shouldConvertBigDecimalToString() {
		// when
		String result = TypeConverter.convert(BigDecimal.ONE, String.class);

		// then
		assertThat(result).isEqualTo("1");
	}

	@Test
	public void shouldConvertBooleanToString() {
		// when
		String result = TypeConverter.convert(true, String.class);

		// then
		assertThat(result).isEqualTo("true");
	}

	@Test
	public void shouldConvertBooleanToString2() {
		// when
		String result = TypeConverter.convert(Boolean.FALSE, String.class);

		// then
		assertThat(result).isEqualTo("false");
	}

	@Test
	public void shouldConvertByteToString() {
		// when
		String result = TypeConverter.convert(Byte.MIN_VALUE, String.class);

		// then
		assertThat(result).isEqualTo("-128");
	}

	@Test
	public void shouldConvertDoubleToString() {
		// when
		String result = TypeConverter.convert(Double.valueOf("0"), String.class);

		// then
		assertThat(result).isEqualTo("0.0");
	}

	@Test
	public void shouldConvertFloatToString() {
		// when
		String result = TypeConverter.convert(Float.valueOf("0"), String.class);

		// then
		assertThat(result).isEqualTo("0.0");
	}

	@Test
	public void shouldConvertLongToString() {
		// when
		String result = TypeConverter.convert(13L, String.class);

		// then
		assertThat(result).isEqualTo("13");
	}

	@Test
	public void shouldConvertShortToString() {
		// when
		String result = TypeConverter.convert(Short.valueOf("0"), String.class);

		// then
		assertThat(result).isEqualTo("0");
	}

	@Test
	public void shouldConvertIntegerToString() {
		// when
		String result = TypeConverter.convert(12, String.class);

		// then
		assertThat(result).isEqualTo("12");
	}
}