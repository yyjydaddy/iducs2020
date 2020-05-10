package iducs.java201200.library;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateObjectTest {
   public static void main(String[] argv) throws Exception {
		/*Date d = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("EE", Locale.KOREA); 
		String str = dateFormat.format(d);
		System.out.println(str);*/
		//formatDate();
		formatDateMulti();
   }
   static void formatDate() throws Exception {
		DateFormat format = new SimpleDateFormat("EEEE, MMM d, yyyy");
		// Calendar형식에서 날짜를 가져온다. 특이점은 Calendar가 singleton 형식이다.
		// Date 값을 가져와서 String으로 변환한다.
		String datestr = format.format(Calendar.getInstance().getTime());
		System.out.println(datestr);
		// Date 객체를 선언해서 String으로 변환한다.
		datestr = format.format(new Date());
		System.out.println(datestr);
		// String 형식을 Date형식으로 변환한다.
		Date date = format.parse("토요일, 6월 10, 2020");
		System.out.println(date);
   }
   static void formatDateMulti() throws Exception {
		ZonedDateTime zonedDateTime = ZonedDateTime.now();
		String datestr = zonedDateTime.format(DateTimeFormatter.ofPattern("HH:mm:ss z E, MMM d, yyyy"));
		System.out.printf("%s", "ZonedDateTime(HH:mm:ss zzzz EEEE, MMM d, yyyy)");
		System.out.printf("[ %s ]\n", datestr);	
  }
}
