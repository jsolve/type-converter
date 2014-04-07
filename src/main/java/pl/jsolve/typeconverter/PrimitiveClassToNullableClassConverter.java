package pl.jsolve.typeconverter;

import java.util.HashMap;
import java.util.Map;

class PrimitiveClassToNullableClassConverter implements Converter<Class<?>, Class<?>> {

	private static final Map<Class<?>, Class<?>> primitivesConverters = new HashMap<>();

	public PrimitiveClassToNullableClassConverter() {
		primitivesConverters.put(byte.class, Byte.class);
		primitivesConverters.put(short.class, Short.class);
		primitivesConverters.put(int.class, Integer.class);
		primitivesConverters.put(long.class, Long.class);
		primitivesConverters.put(float.class, Float.class);
		primitivesConverters.put(double.class, Double.class);
		primitivesConverters.put(boolean.class, Boolean.class);
		primitivesConverters.put(char.class, Character.class);
	}

	@Override
	public Class<?> convert(Class<?> sourceClass) {
		if (sourceClass == null || !sourceClass.isPrimitive()) {
			return sourceClass;
		}
		return primitivesConverters.get(sourceClass);
	}
}