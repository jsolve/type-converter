package pl.jsolve.typeconverter.collectionto;

import java.util.AbstractCollection;

public class CollectionToStringArrayConverter extends CollectionToAbstractConverter<String[]> {

	@Override
	public String[] convert(AbstractCollection<?> source) {
		return source.toArray(new String[] {});
	}
}