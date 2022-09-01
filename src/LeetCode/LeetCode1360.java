package LeetCode;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.logging.SimpleFormatter;

public class LeetCode1360 {
    public static void main(String[] args) {
        Solution1306 ss = new Solution1306();
        int res = ss.daysBetweenDates("2019-06-29", "2019-06-30");
        System.out.println(res);
    }

}

class Solution1306 {
    public int daysBetweenDates(String date1, String date2) {
        return (int)Math.abs(LocalDate.parse(date1).until(LocalDate.parse(date2), ChronoUnit.DAYS));}
}