package pl.jsolve.typeconverter;

import static org.fest.assertions.Assertions.assertThat;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

import pl.jsolve.sweetener.collection.Collections;

public class CollectionToCollectionConversionTest {
	
	@Test
	public void shouldConvertListToSet() {
		// given
		List<String> list = Collections.newArrayList("one", "two", "three");

		// when
		Set<String> set = TypeConverter.convert(list, Set.class);

		// then
		assertThat(set).contains("one", "two", "three");
	}

	@Test
	public void shouldConvertLinkedListToLinkedHashSet() {
		// given
		LinkedList<String> list = Collections.newLinkedList("one", "two", "three");

		// when
		Set<String> set = TypeConverter.convert(list, LinkedHashSet.class);

		// then
		assertThat(set).contains("one", "two", "three");
	}

	@Test
	public void shouldConvertListToHashSet() {
		// given
		List<String> list = Collections.newArrayList("one", "two", "three");

		// when
		Set<String> set = TypeConverter.convert(list, HashSet.class);

		// then
		assertThat(set).contains("one", "two", "three");
	}

	@Test
	public void shouldConvertLinkedListToHashSet() {
		// given
		LinkedList<String> list = Collections.newLinkedList("one", "two", "three");

		// when
		Set<String> set = TypeConverter.convert(list, HashSet.class);

		// then
		assertThat(set).contains("one", "two", "three");
	}

	@Test
	public void shouldConvertListToTreeSet() {
		// given
		List<Integer> arrayList = Collections.newArrayList(1, 2, 3);

		// when
		TreeSet<Integer> result = TypeConverter.convert(arrayList, TreeSet.class);

		// then
		assertThat(result).contains(1, 2, 3);
	}

	@Test
	public void shouldConvertHashSetToTreeSet() {
		// given
		HashSet<String> hashSet = Collections.newHashSet("one", "two", "three");

		// when
		TreeSet<String> result = TypeConverter.convert(hashSet, TreeSet.class);

		// then
		assertThat(result).contains("one", "two", "three");
	}

	@Test
	public void shouldConvertSetToList() {
		// given
		Set<String> set = Collections.newHashSet("one", "two", "three");

		// when
		List<String> result = TypeConverter.convert(set, List.class);

		// then
		assertThat(result).contains("one", "two", "three");
	}

	@Test
	public void shouldConvertLinkedHashSetToLinkedList() {
		// given
		LinkedHashSet<String> linkedHashSet = Collections.newLinkedHashSet("one", "two", "three");

		// when
		LinkedList<String> result = TypeConverter.convert(linkedHashSet, LinkedList.class);

		// then
		assertThat(result).contains("one", "two", "three");
	}

	@Test
	public void shouldConvertHashSetToArrayList() {
		// given
		HashSet<String> linkedHashSet = Collections.newHashSet("one", "two", "three");

		// when
		ArrayList<String> result = TypeConverter.convert(linkedHashSet, ArrayList.class);

		// then
		assertThat(result).contains("one", "two", "three");
	}

	@Test
	public void shouldConvertHashSetToLinkedList() {
		// given
		HashSet<String> linkedHashSet = Collections.newHashSet("one", "two", "three");

		// when
		LinkedList<String> result = TypeConverter.convert(linkedHashSet, LinkedList.class);

		// then
		assertThat(result).contains("one", "two", "three");
	}
}