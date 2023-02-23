package fpt.edu.weather_exercise.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUtils {

    public static String epochToHour(String inputTimestampStr) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH");
        String hour = "";
        try {
            long inputTimestamp = Long.parseLong(inputTimestampStr);
            Date date = new Date(inputTimestamp * 1000);
            hour = sdf.format(date);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return hour;
    }
}
