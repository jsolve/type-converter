package pl.jsolve.typeconverter.enums;

import org.junit.Test;
import pl.jsolve.typeconverter.enumto.EnumToStringConverter;

import static org.fest.assertions.Assertions.assertThat;

public class EnumToStringConverterTest {

	@Test
	public void shouldConvertEnum(){

		//given
		EnumSponsorType sponsorType = EnumSponsorType.GOLD;
		EnumToStringConverter<EnumSponsorType> converter = new EnumToStringConverter<EnumSponsorType>();

		//when
		String result = converter.convert(sponsorType);

		//then
		assertThat(result).isEqualTo("GOLD");
	}
}
