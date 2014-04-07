package pl.jsolve.typeconverter.collectionto;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.List;

public class CollectionToListConverter extends CollectionToAbstractConverter<List<?>> {

	@Override
	public List<?> convert(AbstractCollection<?> source) {
		return new ArrayList<>(source);
	}
}