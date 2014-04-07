package pl.jsolve.typeconverter.collectionto;

import java.util.AbstractCollection;

public class CollectionToLongArrayConverter extends CollectionToAbstractConverter<Long[]> {

	@Override
	public Long[] convert(AbstractCollection<?> source) {
		return source.toArray(new Long[] {});
	}
}