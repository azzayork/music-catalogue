package com.azzayork.musiccatalogue.domain;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

/**
 * @author Aaron York
 * @since 08/10/2017
 */
public class DateUtil {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("d/MM/yyyy");

    private static final DateTimeFormatter ORDINAL_THREE_FORMATTER = DateTimeFormatter.ofPattern("d MMM yyyy");

    private static final DateTimeFormatter ORDINAL_FOUR_FORMATTER = DateTimeFormatter.ofPattern("d MMMM yyyy");

    private static  final Pattern DEFAULT = Pattern.compile("(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)");

    private static  final Pattern ORDINAL_THREE = Pattern.compile("(\\d{1,2})(st|nd|rd|th)\\s([a-zA-Z]{3})\\s(\\d{4})");

    private static  final Pattern ORDINAL_FOUR = Pattern.compile("(\\d{1,2})(st|nd|rd|th)\\s([a-zA-Z]{4,9})\\s(\\d{4})");

    public static LocalDate parse(String date) {
        return date == null || date.isEmpty() ? null : LocalDate.parse(
                date.replaceAll("(?<=\\d)(st|nd|rd|th)", ""), getFormatter(date));
    }

    private static DateTimeFormatter getFormatter(String date) {

        if (DEFAULT.matcher(date).find()) {
            return FORMATTER;
        }
        if (ORDINAL_THREE.matcher(date).find()) {
            return ORDINAL_THREE_FORMATTER;
        }
        if (ORDINAL_FOUR.matcher(date).find()) {
            return ORDINAL_FOUR_FORMATTER;
        }
        return null;
    }
}
