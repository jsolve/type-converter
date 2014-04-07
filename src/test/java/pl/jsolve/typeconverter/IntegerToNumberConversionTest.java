package pl.jsolve.typeconverter;

import static org.fest.assertions.Assertions.assertThat;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.junit.Test;

public class IntegerToNumberConversionTest {
	
	@Test
	public void shouldConvertIntegerToBigDecimal() {
		// given
		Integer integer = 12;

		// when
		BigDecimal result = TypeConverter.convert(integer, BigDecimal.class);

		// then
		assertThat(result.intValue()).isEqualTo(integer);
	}

	@Test
	public void shouldConvertIntegerToBigInteger() {
		// given
		Integer integer = 12;

		// when
		BigInteger result = TypeConverter.convert(integer, BigInteger.class);

		// then
		assertThat(result.intValue()).isEqualTo(integer);
	}

	@Test
	public void shouldConvertIntegerToByte() {
		// given
		Integer integer = 12;

		// when
		Byte result = TypeConverter.convert(integer, Byte.class);

		// then
		assertThat(result.intValue()).isEqualTo(integer);
	}
	
	@Test
	public void shouldConvertIntegerToPrimitiveByte() {
		// given
		Integer integer = 12;

		// when
		byte result = TypeConverter.convert(integer, byte.class);

		// then
		assertThat(result).isEqualTo(integer.byteValue());
	}

	@Test
	public void shouldConvertIntegerToDouble() {
		// given
		Integer integer = 12;

		// when
		Double result = TypeConverter.convert(integer, Double.class);

		// then
		assertThat(result.doubleValue()).isEqualTo(integer.doubleValue());
	}
	
	@Test
	public void shouldConvertIntegerToPrimitiveDouble() {
		// given
		Integer integer = 12;

		// when
		double result = TypeConverter.convert(integer, double.class);

		// then
		assertThat(result).isEqualTo(integer.doubleValue());
	}

	@Test
	public void shouldConvertIntegerToFloat() {
		// given
		Integer integer = 12;

		// when
		Float result = TypeConverter.convert(integer, Float.class);

		// then
		assertThat(result.floatValue()).isEqualTo(integer.floatValue());
	}
	
	@Test
	public void shouldConvertIntegerToPrimtiveFloat() {
		// given
		Integer integer = 12;

		// when
		float result = TypeConverter.convert(integer, float.class);

		// then
		assertThat(result).isEqualTo(integer.floatValue());
	}

	@Test
	public void shouldConvertIntegerToLong() {
		// given
		Integer integer = 12;

		// when
		Long result = TypeConverter.convert(integer, Long.class);

		// then
		assertThat(result.intValue()).isEqualTo(integer);
	}
	
	@Test
	public void shouldConvertIntegerToPrimitiveLong() {
		// given
		Integer integer = 12;

		// when
		long result = TypeConverter.convert(integer, long.class);

		// then
		assertThat(result).isEqualTo(integer.longValue());
	}

	@Test
	public void shouldConvertIntegerToNumber() {
		// given
		Integer integer = 12;

		// when
		Number result = TypeConverter.convert(integer, Number.class);

		// then
		assertThat(result.intValue()).isEqualTo(integer);
	}

	@Test
	public void shouldConvertIntegerToShort() {
		// given
		Integer integer = 12;

		// when
		Short result = TypeConverter.convert(integer, Short.class);

		// then
		assertThat(result.shortValue()).isEqualTo(integer.shortValue());
	}
	
	@Test
	public void shouldConvertIntegerToPrimitiveShort() {
		// given
		Integer integer = 12;

		// when
		short result = TypeConverter.convert(integer, short.class);

		// then
		assertThat(result).isEqualTo(integer.shortValue());
	}

	@Test
	public void shouldConvertIntegerToInteger() {
		// given
		Integer integer = 12;

		// when
		Integer result = TypeConverter.convert(integer, Integer.class);

		// then
		assertThat(result).isEqualTo(integer);
	}
	
	@Test
	public void shouldConvertIntegerToInt() {
		// given
		Integer integer = 12;

		// when
		int result = TypeConverter.convert(integer, int.class);

		// then
		assertThat(result).isEqualTo(integer);
	}
}