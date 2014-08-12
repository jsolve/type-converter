package pl.jsolve.typeconverter.arrayto;

import java.util.HashSet;
import java.util.Set;

public class ArrayToSetConverter extends ArrayToAbstractConverter<Set<?>> {

	@Override
	public Set<?> convert(Object[] source) {
		HashSet<Object> set = new HashSet<Object>();
		java.util.Collections.addAll(set, source);
		return set;
	}
}