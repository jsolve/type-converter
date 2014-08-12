package pl.jsolve.typeconverter.collectionto;

import java.util.AbstractCollection;
import java.util.LinkedHashSet;

public class CollectionToLinkedHashSetConverter extends CollectionToAbstractConverter<LinkedHashSet<?>> {

	@Override
	public LinkedHashSet<?> convert(AbstractCollection<?> source) {
		return new LinkedHashSet<Object>(source);
	}
}