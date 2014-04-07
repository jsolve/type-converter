package pl.jsolve.typeconverter;

import static org.fest.assertions.Assertions.assertThat;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class DatesConversionTest {
	
	@Test
	public void shouldConvertLongToDate() {
		// given
		Long timestamp = 1220227200100L;

		// when
		Date date = TypeConverter.convert(timestamp, Date.class);

		// then
		assertThat(date.getTime()).isEqualTo(timestamp);
	}

	@Test
	public void shouldConvertPrimitiveLongToDate() {
		// given
		long timestamp = 1220227200100L;

		// when
		Date date = TypeConverter.convert(timestamp, Date.class);

		// then
		assertThat(date.getTime()).isEqualTo(timestamp);
	}

	@Test
	public void shouldConvertDateToString() {
		// given
		Date date = new Date(1220227200100L);

		// when
		String result = TypeConverter.convert(date, String.class);

		// then
		assertThat(result).isEqualTo(date.toString());
	}

	@Test
	public void shouldConvertDateToLong() {
		// given
		Date date = new Date(1220227200100L);

		// when
		long result = TypeConverter.convert(date, long.class);

		// then
		assertThat(result).isEqualTo(date.getTime());
	}

	@Test
	public void shouldConvertLongToCalendar() {
		// given
		Long timestamp = 1220227200100L;

		// when
		Calendar result = TypeConverter.convert(timestamp, Calendar.class);

		// then
		assertThat(result.getTimeInMillis()).isEqualTo(timestamp);
	}

	@Test
	public void shouldConvertLongPrimitiveToCalendar() {
		// given
		long timestamp = 1220227200100L;

		// when
		Calendar result = TypeConverter.convert(timestamp, Calendar.class);

		// then
		assertThat(result.getTimeInMillis()).isEqualTo(timestamp);
	}

	@Test
	public void shouldConvertCalendarToString() {
		// given
		Calendar calendar = Calendar.getInstance();

		// when
		String result = TypeConverter.convert(calendar, String.class);

		// then
		assertThat(result).isEqualTo(calendar.toString());
	}

	@Test
	public void shouldConvertCalendarToLong() {
		// given
		Calendar calendar = Calendar.getInstance();

		// when
		Long result = TypeConverter.convert(calendar, Long.class);

		// then
		assertThat(result).isEqualTo(calendar.getTimeInMillis());
	}

	@Test
	public void shouldConvertDateToCalendar() {
		// given
		Date date = new Date(1220227200100L);

		// when
		Calendar calendar = TypeConverter.convert(date, Calendar.class);

		// then
		assertThat(calendar.getTime()).isEqualTo(date);
	}

	@Test
	public void shouldConvertCalendarToDate() {
		// given
		Calendar calendar = Calendar.getInstance();

		// when
		Date date = TypeConverter.convert(calendar, Date.class);

		// then
		assertThat(date).isEqualTo(calendar.getTime());
	}
}