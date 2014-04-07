package pl.jsolve.typeconverter.arrayto;

import java.util.LinkedList;

public class ArrayToLinkedListConverter extends ArrayToAbstractConverter<LinkedList<?>> {

	@Override
	public LinkedList<?> convert(Object[] source) {
		LinkedList<Object> list = new LinkedList<>();
		java.util.Collections.addAll(list, source);
		return list;
	}
}