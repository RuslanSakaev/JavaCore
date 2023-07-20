package com.mynotesapp.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public static String getFormattedDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        return dateFormat.format(new Date());
    }
}
