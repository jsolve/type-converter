package pl.jsolve.typeconverter;

import static java.util.Collections.synchronizedMap;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class ConvertersContainer {

	private final Map<String, Converter<?, ?>> converters = synchronizedMap(new HashMap<String, Converter<?, ?>>());

	public <S, T> void registerConverter(Class<?> s, Class<?> t, Converter<S, T> converter) {
		String converterId = createConverterId(s, t);
		converters.put(converterId, converter);
	}

	public <S, T> void unregisterConverter(Class<S> sourceClass, Class<T> targetClass) {
		String converterId = createConverterId(sourceClass, targetClass);
		converters.remove(converterId);
	}

	private String createConverterId(Class<?> sourceClass, Class<?> targetClass) {
		sourceClass = generalizeClassIfArray(sourceClass);
		return sourceClass + ":to:" + targetClass;
	}

	private Class<?> generalizeClassIfArray(Class<?> sourceClass) {
		if (sourceClass.isArray()) {
			sourceClass = Object[].class;
		}
		return sourceClass;
	}

	@SuppressWarnings("unchecked")
	public <S, T> Converter<S, T> getSuitableConverter(S source, Class<T> targetClass) {
		Class<?> sourceClass = source.getClass();
		Converter<S, T> converter = (Converter<S, T>) getConverter(sourceClass, targetClass);
		if (converter != null) {
			return converter;
		}
		for (Class<?> t : getClassesAndInterfacesOf(targetClass)) {
			for (Class<?> s : getClassesAndInterfacesOf(sourceClass)) {
				converter = (Converter<S, T>) getConverter(s, t);
				if (converter != null) {
					registerConverter(s, targetClass, converter);
					return converter;
				}
			}
		}
		return null;
	}

	private static List<Class<?>> getClassesAndInterfacesOf(final Class<?> targetClass) {
		List<Class<?>> classes = getClasses(targetClass);
		java.util.Collections.addAll(classes, targetClass.getInterfaces());
		classes.add(Object.class);
		return classes;
	}

	private static List<Class<?>> getClasses(Class<?> clazz) {
		List<Class<?>> classes = new LinkedList<>();
		classes.add(clazz);
		while (!Object.class.equals(clazz) && !clazz.isInterface() && !clazz.isPrimitive()) {
			clazz = clazz.getSuperclass();
			classes.add(clazz);
		}
		return classes;
	}

	public <S, T> Converter<S, T> getConverter(Class<S> sourceClass, Class<T> targetClass) {
		return (Converter<S, T>) converters.get(createConverterId(sourceClass, targetClass));
	}
}