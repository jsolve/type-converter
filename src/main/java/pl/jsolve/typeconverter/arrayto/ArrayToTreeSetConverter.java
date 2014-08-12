package pl.jsolve.typeconverter.arrayto;

import pl.jsolve.typeconverter.Converter;

import java.util.TreeSet;

public class ArrayToTreeSetConverter implements Converter<Comparable<?>[], TreeSet<?>> {

	@Override
	public TreeSet<?> convert(Comparable<?>[] source) {
		TreeSet<Object> set = new TreeSet<Object>();
		java.util.Collections.addAll(set, source);
		return set;
	}
}