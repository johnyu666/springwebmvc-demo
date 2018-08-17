package formatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.format.Formatter;

public class DateFormatter implements Formatter<Date> {
	private SimpleDateFormat formate=new SimpleDateFormat("yyyy-MM-dd");
	@Override
	public String print(Date object, Locale locale) {
		// TODO Auto-generated method stub
		return formate.format(object);
	}

	@Override
	public Date parse(String text, Locale locale) throws ParseException {
		// TODO Auto-generated method stub
		return formate.parse(text);
	}

}
