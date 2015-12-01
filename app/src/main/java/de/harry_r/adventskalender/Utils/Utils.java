package de.harry_r.adventskalender.Utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Random;

import de.harry_r.adventskalender.R;

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

    /**
     * Creates a dialog with random comments (door opened too late)
     * @param context context for dialog
     */
    public static void showCommentTooLate(Context context) {
        // get string array from resources
        String[] comments = context.getResources().getStringArray(R.array.comments_too_late);

        // select one string from array using a random generated index
        Random random = new Random();
        int random_index = random.nextInt(comments.length);
        String comment = comments[random_index];

        // special comment on monday
        Calendar cal = Calendar.getInstance();
        if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY) {
            if (random_index > (comments.length/2)) {
                comment = context.getResources().getString(R.string.comment_too_late_monday);
            }
        }

        // create and show alert dialog
        new AlertDialog.Builder(context)
                .setTitle("Zu spät")
                .setMessage(comment)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // do nothing
                    }
                })
                .show();
    }

    /**
     * Creates a dialog with random comments (door opened too early)
     * @param context context for dialog
     */
    public static void showCommentTooEarly(Context context) {
        // get string array from resources
        String[] comments = context.getResources().getStringArray(R.array.comments_too_early);

        // select one string from array using a random generated index
        Random random = new Random();
        int random_index = random.nextInt(comments.length);
        String comment = comments[random_index];

        // create and show alert dialog
        new AlertDialog.Builder(context)
                .setTitle("Zu früh")
                .setMessage(comment)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // do nothing
                    }
                })
                .show();
    }
}
