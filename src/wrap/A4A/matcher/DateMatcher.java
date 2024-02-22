package wrap.A4A.matcher;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public class DateMatcher implements Matcher<Date> {
    private static int threshold = 1;
    @Override
    public int match(Date o1, Date o2) {
        if(o1.equals(o2)){
            return Category.EXACT.getValue();
        }else if((Period.between(convertToLocalDate(o1),convertToLocalDate(o2))).getDays() <= threshold){
            return Category.PARTIAL.getValue();
        }
        else{
            return Category.ONLY.getValue();
        }
    }

    public static LocalDate convertToLocalDate(Date date) {
        return Instant.ofEpochMilli(date.getTime())
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }
}
