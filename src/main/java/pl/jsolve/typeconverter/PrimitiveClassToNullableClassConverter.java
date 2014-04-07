package pl.jsolve.typeconverter;

import java.util.HashMap;
import java.util.Map;

class PrimitiveClassToNullableClassConverter implements Converter<Class<?>, Class<?>> {

	private static final Map<Class<?>, Class<?>> PRIMITIVES_CONVERTERS = new HashMap<>();

	public PrimitiveClassToNullableClassConverter() {
		PRIMITIVES_CONVERTERS.put(byte.class, Byte.class);
		PRIMITIVES_CONVERTERS.put(short.class, Short.class);
		PRIMITIVES_CONVERTERS.put(int.class, Integer.class);
		PRIMITIVES_CONVERTERS.put(long.class, Long.class);
		PRIMITIVES_CONVERTERS.put(float.class, Float.class);
		PRIMITIVES_CONVERTERS.put(double.class, Double.class);
		PRIMITIVES_CONVERTERS.put(boolean.class, Boolean.class);
		PRIMITIVES_CONVERTERS.put(char.class, Character.class);
	}

	@Override
	public Class<?> convert(Class<?> sourceClass) {
		if (sourceClass == null || !sourceClass.isPrimitive()) {
			return sourceClass;
		}
		return PRIMITIVES_CONVERTERS.get(sourceClass);
	}
}