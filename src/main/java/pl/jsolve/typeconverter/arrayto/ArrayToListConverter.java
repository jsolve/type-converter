package pl.jsolve.typeconverter.arrayto;

import java.util.ArrayList;
import java.util.List;

public class ArrayToListConverter extends ArrayToAbstractConverter<List<?>> {

	@Override
	public List<?> convert(Object[] source) {
		ArrayList<Object> list = new ArrayList<Object>();
		java.util.Collections.addAll(list, source);
		return list;
	}
}