package de.harry_r.adventskalender.Utils;

import java.util.Calendar;

public class Utils {
    /**
     * @param dayOfDecember day of december
     * @return 1 if dayOfDecember is the current day, 2 if dayOfDecember is in the past, else 0
     */
    public static int checkDate(int dayOfDecember) {
        Calendar cal = Calendar.getInstance();
        int current_day = cal.get(Calendar.DAY_OF_MONTH);
        if (current_day == dayOfDecember) {
            return 1;
        } else if (current_day > dayOfDecember) {
            return 2;
        } else {
            return 0;
        }
    }
}
