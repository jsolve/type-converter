package pl.jsolve.typeconverter;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

public class PrimitivesConversionTest {

	@Test
	public void shouldConvertIntToString() {
		// when
		int result = TypeConverter.convert("2", int.class);

		// then
		assertThat(result).isEqualTo(2);
	}

	@Test
	public void shouldConvertPrimitiveByteToString() {
		// when
		byte result = TypeConverter.convert("2", byte.class);

		// then
		assertThat(result).isEqualTo((byte) 2);
	}

	@Test
	public void shouldConvertPrimitiveDoubleToPrimitiveInt() {
		// when
		int result = TypeConverter.convert(12.5, int.class);

		// then
		assertThat(result).isEqualTo(12);
	}

	@Test
	public void shouldConvertPrimitiveIntToPrimitiveDouble() {
		// when
		double result = TypeConverter.convert(12, double.class);

		// then
		assertThat(result).isEqualTo(12.0d);
	}
}