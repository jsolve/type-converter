package pl.jsolve.typeconverter.collectionto;

import java.util.AbstractCollection;

public class CollectionToObjectArrayConverter extends CollectionToAbstractConverter<Object[]> {

	@Override
	public Object[] convert(AbstractCollection<?> source) {
		return source.toArray();
	}
}