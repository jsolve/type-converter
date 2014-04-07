package pl.jsolve.typeconverter;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

public class BooleanConvertionTest {

	@Test
	public void shouldConvertBooleanToInteger() {
		// when
		Integer result = TypeConverter.convert(Boolean.TRUE, Integer.class);

		// then
		assertThat(result).isEqualTo(1);
	}

	@Test
	public void shouldConvertBooleanToInteger2() {
		// when
		Integer result = TypeConverter.convert(Boolean.FALSE, Integer.class);

		// then
		assertThat(result).isEqualTo(0);
	}

	@Test
	public void shouldConvertIntegerToBoolean() {
		// when
		Boolean result = TypeConverter.convert(1, Boolean.class);

		// then
		assertThat(result).isSameAs(Boolean.TRUE);
	}

	@Test
	public void shouldConvertIntegerToBoolean2() {
		// when
		Boolean result = TypeConverter.convert(0, Boolean.class);

		// then
		assertThat(result).isSameAs(Boolean.FALSE);
	}

	@Test
	public void shouldConvertPrimitiveBooleanToInt() {
		// when
		int result = TypeConverter.convert(true, int.class);

		// then
		assertThat(result).isEqualTo(1);
	}

	@Test
	public void shouldConvertPrimitiveBooleanToInt2() {
		// when
		int result = TypeConverter.convert(false, int.class);

		// then
		assertThat(result).isEqualTo(0);
	}

	@Test
	public void shouldConvertIntToPrimitiveBoolean() {
		// when
		boolean result = TypeConverter.convert(1, boolean.class);

		// then
		assertThat(result).isSameAs(true);
	}

	@Test
	public void shouldConvertIntToPrimitiveBoolean2() {
		// when
		boolean result = TypeConverter.convert(0, boolean.class);

		// then
		assertThat(result).isSameAs(false);
	}
}