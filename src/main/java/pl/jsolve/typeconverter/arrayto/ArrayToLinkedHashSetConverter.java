package pl.jsolve.typeconverter.arrayto;

import java.util.LinkedHashSet;

public class ArrayToLinkedHashSetConverter extends ArrayToAbstractConverter<LinkedHashSet<?>> {

	@Override
	public LinkedHashSet<?> convert(Object[] source) {
		LinkedHashSet<Object> set = new LinkedHashSet<>();
		java.util.Collections.addAll(set, source);
		return set;
	}
}