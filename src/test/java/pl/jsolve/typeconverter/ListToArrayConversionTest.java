package pl.jsolve.typeconverter;

import static org.fest.assertions.Assertions.assertThat;
import static pl.jsolve.sweetener.tests.assertion.ThrowableAssertions.assertThrowable;
import static pl.jsolve.sweetener.tests.catcher.ExceptionCatcher.tryToCatch;

import java.util.List;

import org.junit.Test;

import pl.jsolve.sweetener.collection.Collections;
import pl.jsolve.sweetener.tests.catcher.ExceptionalOperation;

public class ListToArrayConversionTest {

	@Test
	public void shouldConvertListToStringsArray() {
		// given
		List<String> listOfStrings = Collections.newArrayList("one", "two", "three");

		// when
		String[] result = TypeConverter.convert(listOfStrings, String[].class);

		// then
		assertThat(result).contains("one", "two", "three");
	}

	@Test
	public void shouldConvertListToBooleanArray() {
		// given
		List<Boolean> list = Collections.newArrayList(true, false, false);

		// when
		Boolean[] result = TypeConverter.convert(list, Boolean[].class);

		// then
		assertThat(result).contains(true, false, false);
	}

	@Test
	public void shouldConvertListToByteArray() {
		// given
		List<Byte> list = Collections.newArrayList(Byte.MIN_VALUE, Byte.MAX_VALUE);

		// when
		Byte[] result = TypeConverter.convert(list, Byte[].class);

		// then
		assertThat(result).contains(Byte.MAX_VALUE, Byte.MIN_VALUE);
	}

	@Test
	public void shouldConvertListToCharArray() {
		// given
		List<Character> list = Collections.newArrayList('a', 'b', 'c');

		// when
		Character[] result = TypeConverter.convert(list, Character[].class);

		// then
		assertThat(result).contains('a', 'b', 'c');
	}

	@Test
	public void shouldConvertListToDoubleArray() {
		// given
		List<Double> list = Collections.newArrayList(0.1, 0.2, 0.3);

		// when
		Double[] result = TypeConverter.convert(list, Double[].class);

		// then
		assertThat(result).contains(0.1, 0.2, 0.3);
	}

	@Test
	public void shouldConvertListToFloatArray() {
		// given
		List<Float> list = Collections.newArrayList(0.1f, 0.2f, 0.3f);

		// when
		Float[] result = TypeConverter.convert(list, Float[].class);

		// then
		assertThat(result).contains(0.1f, 0.2f, 0.3f);
	}

	@Test
	public void shouldConvertListToIntegerArray() {
		// given
		List<Integer> list = Collections.newArrayList(1, 2, 3);

		// when
		Integer[] result = TypeConverter.convert(list, Integer[].class);

		// then
		assertThat(result).contains(1, 2, 3);
	}

	@Test
	public void shouldConvertListToLongArray() {
		// given
		List<Long> list = Collections.newArrayList(1L, 2L, 3L);

		// when
		Long[] result = TypeConverter.convert(list, Long[].class);

		// then
		assertThat(result).contains(1L, 2L, 3L);
	}

	@Test
	public void shouldConvertListToShortArray() {
		// given
		List<Short> list = Collections.newArrayList(Short.MIN_VALUE, Short.MAX_VALUE);

		// when
		Short[] result = TypeConverter.convert(list, Short[].class);

		// then
		assertThat(result).contains(Short.MIN_VALUE, Short.MAX_VALUE);
	}

	@Test
	public void shouldConvertListToObjectArray() {
		// given
		Object object = new Object();
		List<Object> list = Collections.newArrayList(object);

		// when
		Object[] result = TypeConverter.convert(list, Object[].class);

		// then
		assertThat(result).contains(object);
	}

	@Test
	public void shouldNotConvertListToArrayWithDifferentElementsType() {
		// when
		ConversionException caughtException = tryToCatch(ConversionException.class, new ExceptionalOperation() {

			@Override
			public void operate() throws Exception {
				TypeConverter.convert(Collections.newArrayList("one", "two", "three"), Integer[].class);
			}
		});

		// then
		assertThrowable(caughtException).isThrown().withMessageContaining(ArrayStoreException.class.getName());
	}
}