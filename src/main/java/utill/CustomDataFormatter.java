package utill;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomDataFormatter {

    private static final Pattern PATTERN = Pattern.compile("((\\d+|В)\\s\\W+|О дате старта будет объявлено позже)");
    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("d MMMM", new Locale("ru"));

    private CustomDataFormatter() {
    }

    public static String stringToStringDate(String string) {
        Matcher matcher = PATTERN.matcher(string);
        if (matcher.find()) string = matcher.group();
        string = string.replaceAll("В ", "1 ")
                .replaceAll("ае", "ая")
                .replaceAll("О дате старта будет объявлено позже", "31 декабря");
        return string;
    }

    public static Date stringDateToData(final String value) {
        try {
            return DATE_FORMAT.parse(value);
        } catch (ParseException ignore) {
            return Date.from(LocalDateTime.of(2022, 12, 3, 12, 0).toInstant(ZoneOffset.MAX));
        }
    }

    public static String dateToString(final Date date) {
        return DATE_FORMAT.format(date).replaceAll("31 декабря", "О дате старта будет объявлено позже");
    }

}
