package pl.jsolve.typeconverter.enums;

import org.junit.Test;
import pl.jsolve.typeconverter.TypeConverter;
import pl.jsolve.typeconverter.enumto.EnumToStringConverter;

import static org.fest.assertions.Assertions.assertThat;

public class EnumToStringConverterTest {

	@Test
	public void shouldConvertEnum(){

		//when
		String result = TypeConverter.convert(EnumSponsorType.GOLD, String.class);

		//then
		assertThat(result).isEqualTo("GOLD");
	}
}
