package iducs.java.datetime;

import static org.junit.jupiter.api.Assertions.*;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.DateTimeException;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.chrono.IsoChronology;
import java.time.format.DateTimeFormatter;
import java.time.zone.ZoneRules;
import java.time.zone.ZoneRulesException;

import org.junit.jupiter.api.Test;

class SRS310Test { //https://d2.naver.com/helloworld/645609 : junit4 -> junit 5

	@Test
	public void shouldGetAfterOneDay() {
		LocalDate theDay = IsoChronology.INSTANCE.date(1582, 10, 4);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
		assertThat(theDay.format(formatter)).isEqualTo("1582.10.04");
		
		LocalDate nextDay = theDay.plusDays(1);
		assertThat(nextDay.format(formatter)).isEqualTo("1582.10.05");
	}
	
	@Test
	public void shouldGetAfterOneHour() {
		ZoneId seoul = ZoneId.of("Asia/Seoul");
		ZonedDateTime theTime = ZonedDateTime.of(1988, 5, 7, 23, 0, 0, 0, seoul);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm");
		assertThat(theTime.format(formatter)).isEqualTo("1988.05.07 23:00");
		ZoneRules seoulRules = seoul.getRules();
		assertThat(seoulRules.isDaylightSavings(Instant.from(theTime))).isFalse();

		ZonedDateTime after1Hour = theTime.plusHours(1);
		assertThat(after1Hour.format(formatter)).isEqualTo("1988.05.08 01:00");
		assertThat(seoulRules.isDaylightSavings(Instant.from(after1Hour))).isTrue();
	}
	
	@Test
	public void shouldGetAfterOneMinute() {
		ZoneId seoul = ZoneId.of("Asia/Seoul");
		ZonedDateTime theTime = ZonedDateTime.of(1961, 8, 9, 23, 59, 59, 0, seoul);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm");
		assertThat(theTime.format(formatter)).isEqualTo("1961.08.09 23:59");
		
		ZonedDateTime after1Minute = theTime.plusMinutes(1);
		assertThat(after1Minute.format(formatter)).isEqualTo("1961.08.10 00:30");
	}

	@Test
	public void shouldGetAfterTwoSecond() {
		ZoneId utc = ZoneId.of("UTC");
		ZonedDateTime theTime = ZonedDateTime.of(2012, 6, 30, 23, 59, 59, 0, utc);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss");
		assertThat(theTime.format(formatter)).isEqualTo("2012.06.30 23:59:59");
		
		ZonedDateTime after2Seconds = theTime.plusSeconds(2);
		assertThat(after2Seconds.format(formatter)).isEqualTo("2012.07.01 00:00:01");
	}

	@Test
	public void shouldThrowExceptionWhenWrongTimeZoneId(){
		ZoneId.of("Seoul/Asia");
		Throwable e = assertThrows(ZoneRulesException.class, 
				() -> { throw new ZoneRulesException("Zone Required"); }); 
		assertEquals("Zone Required", e.getMessage());
		
	}
	
	@Test
	public void shouldGetDate() {
		LocalDate theDay = LocalDate.of(1999, 12, 31);
		
		assertThat(theDay.getYear()).isEqualTo(1999);
		assertThat(theDay.getMonthValue()).isEqualTo(12);		
		assertThat(theDay.getDayOfMonth()).isEqualTo(31);		
	}
	
	@Test
	public void shouldNotAcceptWrongDate() {
		LocalDate.of(1999, 12, 31);
		Throwable e = assertThrows(DateTimeException.class, 
				() -> { throw new DateTimeException("LocalDate Required"); }); 
		assertEquals("LocalDate Required", e.getMessage());
	}

	@Test
	public void shouldGetDayOfWeek() {
		LocalDate theDay = LocalDate.of(2014, 1, 1);
		
		DayOfWeek dayOfWeek = theDay.getDayOfWeek();
		assertThat(dayOfWeek).isEqualTo(DayOfWeek.WEDNESDAY);
	}

}

