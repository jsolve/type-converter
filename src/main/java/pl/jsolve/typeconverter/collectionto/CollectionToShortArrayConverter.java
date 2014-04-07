package pl.jsolve.typeconverter.collectionto;

import java.util.AbstractCollection;

public class CollectionToShortArrayConverter extends CollectionToAbstractConverter<Short[]> {

	@Override
	public Short[] convert(AbstractCollection<?> source) {
		return source.toArray(new Short[] {});
	}
}