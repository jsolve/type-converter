package pl.jsolve.typeconverter.collectionto;

import java.util.AbstractCollection;
import java.util.LinkedList;

public class CollectionToLinkedListConverter extends CollectionToAbstractConverter<LinkedList<?>> {

	@Override
	public LinkedList<?> convert(AbstractCollection<?> source) {
		return new LinkedList<Object>(source);
	}
}