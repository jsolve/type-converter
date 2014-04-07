package pl.jsolve.typeconverter;

public class ConversionException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ConversionException(Class<?> sourceClass, Class<?> targetClass) {
		this("", sourceClass, targetClass, null);
	}

	public ConversionException(String message, Class<?> sourceClass, Class<?> targetClass) {
		this(message, sourceClass, targetClass, null);
	}

	public ConversionException(Class<?> sourceClass, Class<?> targetClass, Exception e) {
		this("Reason: " + e.toString(), sourceClass, targetClass, e);
	}

	public ConversionException(String message, Class<?> sourceClass, Class<?> targetClass, Exception e) {
		super(String.format("Cannot convert from %s to %s. ", sourceClass, targetClass) + message, e);
	}
}