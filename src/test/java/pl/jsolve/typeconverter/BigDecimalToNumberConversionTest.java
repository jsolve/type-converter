package pl.jsolve.typeconverter;

import static org.fest.assertions.Assertions.assertThat;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

public class BigDecimalToNumberConversionTest {

	@Test
	public void shouldConvertBigDecimalToInteger() {
		// given
		BigDecimal bigDecimal = BigDecimal.TEN;

		// when
		Integer result = TypeConverter.convert(bigDecimal, Integer.class);

		// then
		assertThat(result).isEqualTo(bigDecimal.intValue());
	}

	@Test
	public void shouldConvertBigDecimalToBigInteger() {
		// given
		BigDecimal bigDecimal = BigDecimal.TEN;

		// when
		BigInteger result = TypeConverter.convert(bigDecimal, BigInteger.class);

		// then
		assertThat(result.intValue()).isEqualTo(bigDecimal.intValue());
	}

	@Test
	public void shouldConvertBigDecimalToBoolean() {
		// given
		BigDecimal bigDecimal = BigDecimal.ZERO;

		// when
		Boolean result = TypeConverter.convert(bigDecimal, Boolean.class);

		// then
		assertThat(result).isFalse();
	}

	@Test
	public void shouldConvertBigDecimalToBoolean2() {
		// given
		BigDecimal bigDecimal = BigDecimal.TEN;

		// when
		Boolean result = TypeConverter.convert(bigDecimal, Boolean.class);

		// then
		assertThat(result).isTrue();
	}

	@Test
	public void shouldConvertBigDecimalToByte() {
		// given
		BigDecimal bigDecimal = BigDecimal.TEN;

		// when
		Byte result = TypeConverter.convert(bigDecimal, Byte.class);

		// then
		assertThat(result).isEqualTo(bigDecimal.byteValue());
	}

	@Test
	public void shouldConvertBigDecimalToDouble() {
		// given
		BigDecimal bigDecimal = BigDecimal.TEN;

		// when
		Double result = TypeConverter.convert(bigDecimal, Double.class);

		// then
		assertThat(result).isEqualTo(bigDecimal.doubleValue());
	}

	@Test
	public void shouldConvertBigDecimalToFloat() {
		// given
		BigDecimal bigDecimal = BigDecimal.TEN;

		// when
		Float result = TypeConverter.convert(bigDecimal, Float.class);

		// then
		assertThat(result).isEqualTo(bigDecimal.floatValue());
	}

	@Test
	public void shouldConvertBigDecimalToLong() {
		// given
		BigDecimal bigDecimal = BigDecimal.TEN;

		// when
		Long result = TypeConverter.convert(bigDecimal, Long.class);

		// then
		assertThat(result).isEqualTo(bigDecimal.longValue());
	}

	@Test
	public void shouldConvertBigDecimalToShort() {
		// given
		BigDecimal bigDecimal = BigDecimal.TEN;

		// when
		Short result = TypeConverter.convert(bigDecimal, Short.class);

		// then
		assertThat(result).isEqualTo(bigDecimal.shortValue());
	}

	// array to collections conversion

	@Test
	public void shouldConvertArrayToHashSet() {
		// given
		Integer[] arrayOfIntegers = new Integer[] { 1, 2, 3 };

		// when
		HashSet<Integer> result = TypeConverter.convert(arrayOfIntegers, HashSet.class);

		// then
		assertThat(result).contains(1, 2, 3);
	}

	@Test
	public void shouldConvertArrayToSet() {
		// given
		Integer[] arrayOfIntegers = new Integer[] { 1, 2, 3 };

		// when
		Set<Integer> result = TypeConverter.convert(arrayOfIntegers, Set.class);

		// then
		assertThat(result).contains(1, 2, 3);
	}

	@Test
	public void shouldConvertArrayToTreeSet() {
		// given
		Integer[] arrayOfIntegers = new Integer[] { 1, 2, 3 };

		// when
		TreeSet<Integer> result = TypeConverter.convert(arrayOfIntegers, TreeSet.class);

		// then
		assertThat(result).contains(1, 2, 3);
	}

	@Test
	public void shouldConvertArrayToLinkedHashSet() {
		// given
		String[] arrayOfStrings = new String[] { "one", "two", "three" };

		// when
		LinkedHashSet<String> result = TypeConverter.convert(arrayOfStrings, LinkedHashSet.class);

		// then
		assertThat(result).contains("one", "two", "three");
	}

	@Test
	public void shouldConvertArrayToArrayList() {
		// given
		String[] arrayOfStrings = new String[] { "one", "two", "three" };

		// when
		ArrayList<String> result = TypeConverter.convert(arrayOfStrings, ArrayList.class);

		// then
		assertThat(result).contains("one", "two", "three");
	}

	@Test
	public void shouldConvertArrayToList() {
		// given
		String[] arrayOfStrings = new String[] { "one", "two", "three" };

		// when
		ArrayList<String> result = TypeConverter.convert(arrayOfStrings, ArrayList.class);

		// then
		assertThat(result).contains("one", "two", "three");
	}

	@Test
	public void shouldConvertArrayToLinkedList() {
		// given
		Integer[] arrayOfIntegers = new Integer[] { 1, 2, 3 };

		// when
		LinkedList<Integer> result = TypeConverter.convert(arrayOfIntegers, LinkedList.class);

		// then
		assertThat(result).contains(1, 2, 3);
	}
}