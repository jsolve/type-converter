package pl.jsolve.typeconverter.collectionto;

import java.util.AbstractCollection;

public class CollectionToBooleanArrayConverter extends CollectionToAbstractConverter<Boolean[]> {

	@Override
	public Boolean[] convert(AbstractCollection<?> source) {
		return source.toArray(new Boolean[] {});
	}
}