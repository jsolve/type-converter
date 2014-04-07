package pl.jsolve.typeconverter;

public interface Converter<S, T> {

	T convert(S source);
}
