package com.java.se7;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ssri52 on 12/22/2015.
 */
public class Main {

    public static void main(String[] args) {
        String pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        try {
            Date date = simpleDateFormat.parse("2015-12-09T18:02:35.0000000Z");
            System.out.print(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
