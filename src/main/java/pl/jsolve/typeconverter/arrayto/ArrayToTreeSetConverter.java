package pl.jsolve.typeconverter.arrayto;

import java.util.TreeSet;

import pl.jsolve.typeconverter.Converter;

public class ArrayToTreeSetConverter implements Converter<Comparable<?>[], TreeSet<?>> {

	@Override
	public TreeSet<?> convert(Comparable<?>[] source) {
		TreeSet<Object> set = new TreeSet<>();
		java.util.Collections.addAll(set, source);
		return set;
	}
}