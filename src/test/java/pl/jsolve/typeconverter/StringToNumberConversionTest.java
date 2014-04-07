package pl.jsolve.typeconverter;

import static org.fest.assertions.Assertions.assertThat;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.junit.Test;

public class StringToNumberConversionTest {

	@Test
	public void shouldConvertStringToBoolean() {
		// when
		boolean result = TypeConverter.convert("     TrUe    	", Boolean.class);

		// then
		assertThat(result).isTrue();
	}

	@Test
	public void shouldConvertStringToBoolean2() {
		// when
		boolean result = TypeConverter.convert("False", Boolean.class);

		// then
		assertThat(result).isFalse();
	}

	@Test
	public void shouldConvertStringToNumber() {
		// when
		Number result = TypeConverter.convert("12", Number.class);

		// then
		assertThat(result.intValue()).isEqualTo(12);
	}

	@Test
	public void shouldConvertStringToInteger() {
		// when
		Integer result = TypeConverter.convert("12", Integer.class);

		// then
		assertThat(result).isEqualTo(12);
	}

	@Test
	public void shouldConvertStringToBigDecimal() {
		// when
		BigDecimal result = TypeConverter.convert("12", BigDecimal.class);

		// then
		assertThat(result).isEqualTo(BigDecimal.valueOf(12.0));
	}

	@Test
	public void shouldConvertStringToBigInteger() {
		// when
		BigInteger result = TypeConverter.convert("12", BigInteger.class);

		// then
		assertThat(result).isEqualTo(BigInteger.valueOf(12L));
	}

	@Test
	public void shouldConvertStringToByte() {
		// when
		Byte result = TypeConverter.convert("12", Byte.class);

		// then
		assertThat(result).isEqualTo(Byte.valueOf("12"));
	}

	@Test
	public void shouldConvertStringToDouble() {
		// when
		Double result = TypeConverter.convert("12", Double.class);

		// then
		assertThat(result).isEqualTo(Double.valueOf("12"));
	}

	@Test
	public void shouldConvertStringToFloat() {
		// when
		Float result = TypeConverter.convert("12", Float.class);

		// then
		assertThat(result).isEqualTo(Float.valueOf("12"));
	}

	@Test
	public void shouldConvertStringToLong() {
		// when
		Long result = TypeConverter.convert("12", Long.class);

		// then
		assertThat(result).isEqualTo(12L);
	}

	@Test
	public void shouldConvertStringToShort() {
		// when
		Short result = TypeConverter.convert("12", Short.class);

		// then
		assertThat(result).isEqualTo(Short.valueOf("12"));
	}

	@Test
	public void shouldConvertStringToString() {
		// given
		String string = "Silence is golden.";

		// when
		String result = TypeConverter.convert(string, String.class);

		// then
		assertThat(result).isSameAs(string);
	}

	@Test
	public void shouldConvertStringToPrimitiveBoolean() {
		// when
		boolean result = TypeConverter.convert("     TrUe    	", boolean.class);

		// then
		assertThat(result).isTrue();
	}

	@Test
	public void shouldConvertStringToPrimitiveBoolean2() {
		// when
		boolean result = TypeConverter.convert("False", boolean.class);

		// then
		assertThat(result).isFalse();
	}

	@Test
	public void shouldConvertStringToInt() {
		// when
		Integer result = TypeConverter.convert("12", int.class);

		// then
		assertThat(result).isSameAs(12);
	}

	@Test
	public void shouldConvertStringToPrimtiveByte() {
		// when
		Byte result = TypeConverter.convert("12", byte.class);

		// then
		assertThat(result).isSameAs((byte) 12);
	}

	@Test
	public void shouldConvertStringToPrimitiveDouble() {
		// when
		Double result = TypeConverter.convert("12", double.class);

		// then
		assertThat(result).isEqualTo(12.0d);
	}

	@Test
	public void shouldConvertStringToPrimitiveFloat() {
		// when
		Float result = TypeConverter.convert("12", float.class);

		// then
		assertThat(result).isEqualTo(12f);
	}

	@Test
	public void shouldConvertStringToPrimitiveLong() {
		// when
		Long result = TypeConverter.convert("12", long.class);

		// then
		assertThat(result).isSameAs(12L);
	}

	@Test
	public void shouldConvertStringToPrimitiveShort() {
		// when
		Short result = TypeConverter.convert("12", short.class);

		// then
		assertThat(result).isSameAs((short) 12);
	}
}