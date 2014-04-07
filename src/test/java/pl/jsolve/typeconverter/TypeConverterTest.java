package pl.jsolve.typeconverter;

import static org.fest.assertions.Assertions.assertThat;
import static pl.jsolve.sweetener.tests.assertion.ThrowableAssertions.assertThrowable;
import static pl.jsolve.sweetener.tests.catcher.ExceptionCatcher.tryToCatch;
import static pl.jsolve.sweetener.tests.stub.hero.HeroProfiledBuilder.aCaptainAmerica;

import org.junit.Test;

import pl.jsolve.sweetener.tests.catcher.ExceptionalOperation;
import pl.jsolve.sweetener.tests.stub.hero.Hero;
import pl.jsolve.sweetener.tests.stub.person.Person;
import pl.jsolve.sweetener.tests.stub.person.Student;

public class TypeConverterTest {

	@Test
	public void shouldConvertNull() {
		// when
		Hero result = TypeConverter.convert(null, Hero.class);

		// then
		assertThat(result).isNull();
	}

	@Test
	public void shouldCastStudentToPerson() {
		// given
		Student student = prepareStudent();

		// when
		Person person = TypeConverter.convert(student, Person.class);

		// then
		assertThat(person.getFirstName()).isEqualTo(student.getFirstName());
		assertThat(person.getLastName()).isEqualTo(student.getLastName());
		assertThat(person.getAge()).isEqualTo(student.getAge());
	}

	private Student prepareStudent() {
		Student student = new Student();
		student.setFirstName("Adam");
		student.setLastName("Bien");
		student.setAge(28);
		return student;
	}

	@Test
	public void shouldNotFindSuitableConverter() {
		// when
		ConversionException caughtException = tryToCatch(ConversionException.class, new ExceptionalOperation() {

			@Override
			public void operate() throws Exception {
				TypeConverter.convert(new Hero(), Student.class);
			}
		});

		// then
		assertThrowable(caughtException).withMessageContaining("Cannot convert from " + Hero.class + " to " + Student.class).isThrown();
	}

	@Test
	public void shouldConvertHeroToPerson() {
		// given
		Hero hero = aCaptainAmerica().build();
		TypeConverter.registerConverter(Hero.class, Person.class, new Converter<Hero, Person>() {

			@Override
			public Person convert(Hero source) {
				Person target = new Person();
				target.setFirstName(source.getFirstName());
				target.setLastName(source.getLastName());
				return target;
			}
		});

		// when
		Person person = TypeConverter.convert(hero, Person.class);

		// then
		assertThat(person.getFirstName()).isEqualTo(hero.getFirstName());
		assertThat(person.getLastName()).isEqualTo(hero.getLastName());

		TypeConverter.unregisterConverter(Hero.class, Person.class);
	}

	@Test
	public void shouldConvertHeroToObject() {
		// given
		Hero hero = aCaptainAmerica().build();

		// when
		Object result = TypeConverter.convert(hero, Object.class);

		// then
		assertThat(result).isInstanceOf(Hero.class);
	}
}