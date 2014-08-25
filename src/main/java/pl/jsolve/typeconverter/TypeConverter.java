package pl.jsolve.typeconverter;

import java.lang.reflect.Method;

import pl.jsolve.typeconverter.arrayto.ArrayToLinkedHashSetConverter;
import pl.jsolve.typeconverter.arrayto.ArrayToLinkedListConverter;
import pl.jsolve.typeconverter.arrayto.ArrayToListConverter;
import pl.jsolve.typeconverter.arrayto.ArrayToSetConverter;
import pl.jsolve.typeconverter.arrayto.ArrayToTreeSetConverter;
import pl.jsolve.typeconverter.collectionto.CollectionToBooleanArrayConverter;
import pl.jsolve.typeconverter.collectionto.CollectionToByteArrayConverter;
import pl.jsolve.typeconverter.collectionto.CollectionToCharacterArrayConverter;
import pl.jsolve.typeconverter.collectionto.CollectionToDoubleArrayConverter;
import pl.jsolve.typeconverter.collectionto.CollectionToFloatArrayConverter;
import pl.jsolve.typeconverter.collectionto.CollectionToIntegerArrayConverter;
import pl.jsolve.typeconverter.collectionto.CollectionToLinkedHashSetConverter;
import pl.jsolve.typeconverter.collectionto.CollectionToLinkedListConverter;
import pl.jsolve.typeconverter.collectionto.CollectionToListConverter;
import pl.jsolve.typeconverter.collectionto.CollectionToLongArrayConverter;
import pl.jsolve.typeconverter.collectionto.CollectionToObjectArrayConverter;
import pl.jsolve.typeconverter.collectionto.CollectionToSetConverter;
import pl.jsolve.typeconverter.collectionto.CollectionToShortArrayConverter;
import pl.jsolve.typeconverter.collectionto.CollectionToStringArrayConverter;
import pl.jsolve.typeconverter.collectionto.CollectionToTreeSetConverter;
import pl.jsolve.typeconverter.enumto.EnumToStringConverter;
import pl.jsolve.typeconverter.numberto.NumberToBigDecimalConverter;
import pl.jsolve.typeconverter.numberto.NumberToBigIntegerConverter;
import pl.jsolve.typeconverter.numberto.NumberToBooleanConverter;
import pl.jsolve.typeconverter.numberto.NumberToByteConverter;
import pl.jsolve.typeconverter.numberto.NumberToDoubleConverter;
import pl.jsolve.typeconverter.numberto.NumberToFloatConverter;
import pl.jsolve.typeconverter.numberto.NumberToIntegerConverter;
import pl.jsolve.typeconverter.numberto.NumberToLongConverter;
import pl.jsolve.typeconverter.numberto.NumberToShortConverter;
import pl.jsolve.typeconverter.stringto.*;

public final class TypeConverter {

	private static final PrimitiveClassToNullableClassConverter PRIMITIVES_CONVERTER = new PrimitiveClassToNullableClassConverter();
	private static final ConvertersContainer convertersContainer = new ConvertersContainer();

	private TypeConverter() {
		throw new AssertionError("Using constructor of this class is prohibited.");
	}

	static {
		registerConverter(new BooleanToIntegerConverter());
		registerConverter(new ObjectToStringConverter());

		// string to numbers
		registerConverter(new StringToBooleanConverter());
		registerConverter(new StringToNumberConverter());
		registerConverter(new StringToIntegerConverter());
		registerConverter(new StringToShortConverter());
		registerConverter(new StringToLongConverter());
		registerConverter(new StringToBigDecimalConverter());
		registerConverter(new StringToBigIntegerConverter());
		registerConverter(new StringToByteConverter());
		registerConverter(new StringToDoubleConverter());
		registerConverter(new StringToFloatConverter());

		// number to numbers
		registerConverter(new NumberToBooleanConverter());
		registerConverter(new NumberToIntegerConverter());
		registerConverter(new NumberToShortConverter());
		registerConverter(new NumberToLongConverter());
		registerConverter(new NumberToBigDecimalConverter());
		registerConverter(new NumberToBigIntegerConverter());
		registerConverter(new NumberToByteConverter());
		registerConverter(new NumberToDoubleConverter());
		registerConverter(new NumberToFloatConverter());

		// array to collections
		registerConverter(new ArrayToSetConverter());
		registerConverter(new ArrayToTreeSetConverter());
		registerConverter(new ArrayToLinkedHashSetConverter());
		registerConverter(new ArrayToListConverter());
		registerConverter(new ArrayToLinkedListConverter());

		// collection to arrays
		registerConverter(new CollectionToStringArrayConverter());
		registerConverter(new CollectionToBooleanArrayConverter());
		registerConverter(new CollectionToByteArrayConverter());
		registerConverter(new CollectionToCharacterArrayConverter());
		registerConverter(new CollectionToDoubleArrayConverter());
		registerConverter(new CollectionToFloatArrayConverter());
		registerConverter(new CollectionToIntegerArrayConverter());
		registerConverter(new CollectionToLongArrayConverter());
		registerConverter(new CollectionToShortArrayConverter());
		registerConverter(new CollectionToObjectArrayConverter());

		// collection to collections
		registerConverter(new CollectionToSetConverter());
		registerConverter(new CollectionToLinkedHashSetConverter());
		registerConverter(new CollectionToTreeSetConverter());
		registerConverter(new CollectionToListConverter());
		registerConverter(new CollectionToLinkedListConverter());

		// date
		registerConverter(new LongToDateConverter());
		registerConverter(new DateToLongConverter());
		registerConverter(new LongToCalendarConverter());
		registerConverter(new CalendarToLongConverter());
		registerConverter(new DateToCalendarConverter());
		registerConverter(new CalendarToDateConverter());

		// enum conversions
		registerConverter(new EnumToStringConverter());

	}
	@SuppressWarnings("unchecked")
	private static <S, T> void registerConverter(Converter<S, T> converter) {
		Method convertMethod = converter.getClass().getMethods()[0];
		Class<S> sourceClass = (Class<S>) convertMethod.getParameterTypes()[0];
		Class<T> targetClass = (Class<T>) convertMethod.getReturnType();
		convertersContainer.registerConverter(sourceClass, targetClass, converter);
	}

	public static <S, T> T convert(S source, Class<T> targetClass) {
		if (source == null || targetClass == null) {
			return null;
		}
		if (targetClass.isPrimitive()) {
			targetClass = (Class<T>) PRIMITIVES_CONVERTER.convert(targetClass);
		}
		if (isCastableToClass(source, targetClass)) {
			return targetClass.cast(source);
		}
		return tryToConvertUsingRegisteredConverters(source, targetClass);
	}

	private static boolean isCastableToClass(Object object, Class<?> clazz) {
		return clazz.isAssignableFrom(object.getClass());
	}

	private static <S, T> T tryToConvertUsingRegisteredConverters(S source, Class<T> targetClass) {
		Converter<S, T> converter = convertersContainer.getSuitableConverter(source, targetClass);
		throwExceptionWhenNoSuitableConverterWasFound(source, targetClass, converter);
		try {
			return targetClass.cast(converter.convert(source));
		} catch (Exception e) {
			throw new ConversionException(source.getClass(), targetClass, e);
		}
	}

	private static <S, T> void throwExceptionWhenNoSuitableConverterWasFound(S source, Class<T> targetClass, Converter<S, T> converter) {
		if (converter == null) {
			throw new ConversionException("No suitable converter was found. Use registerConverter() method to add your own converter",
					source.getClass(), targetClass);
		}
	}

	public static <S, T> void registerConverter(Class<S> sourceClass, Class<T> targetClass, Converter<S, T> converter) {
		convertersContainer.registerConverter(sourceClass, targetClass, converter);
	}

	public static <S, T> void unregisterConverter(Class<S> sourceClass, Class<T> targetClass) {
		convertersContainer.unregisterConverter(sourceClass, targetClass);
	}
}