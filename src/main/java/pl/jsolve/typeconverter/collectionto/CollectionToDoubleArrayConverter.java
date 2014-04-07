package pl.jsolve.typeconverter.collectionto;

import java.util.AbstractCollection;

public class CollectionToDoubleArrayConverter extends CollectionToAbstractConverter<Double[]> {

	@Override
	public Double[] convert(AbstractCollection<?> source) {
		return source.toArray(new Double[] {});
	}
}