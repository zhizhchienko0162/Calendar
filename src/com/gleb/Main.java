package com.gleb;

import java.time.Duration;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Calendar calendar = Calendar.getInstance();

        int year = calendar.getWeekYear();
        int month = scanner.nextInt();
        int day = scanner.nextInt();

        String nextStr = year + "-" + String.format("%02d", month) + "-" + String.format("%02d", day) + "T00:00:00Z";
        Instant next = DateTimeFormatter.ISO_ZONED_DATE_TIME.parse(nextStr, Instant::from);
        Instant now = Instant.now();
        Duration diff = Duration.between(now, next);

        long out = ((GregorianCalendar)calendar).isLeapYear(year)? (365 + diff.toDays()) % 365: (366 + diff.toDays()) % 366;

        System.out.println(out);
    }
}
