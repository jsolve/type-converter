package pl.jsolve.typeconverter.collectionto;

import java.util.AbstractCollection;

public class CollectionToIntegerArrayConverter extends CollectionToAbstractConverter<Integer[]> {

	@Override
	public Integer[] convert(AbstractCollection<?> source) {
		return source.toArray(new Integer[] {});
	}
}