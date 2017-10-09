package com.azzayork.musiccatalogue.domain;

import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * @author Aaron York
 * @since 08/10/2017
 */
public class DateUtilTest {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("d/MM/yyyy");

    @Test
    public void testParseDefault() {
        LocalDate date = DateUtil.parse("1/02/2017");
        assertTrue(date.equals(LocalDate.parse("1/02/2017", FORMATTER)));

    }

    @Test
    public void testParseOrdinalThree() {
        LocalDate date = DateUtil.parse("1st Feb 2017");
        assertTrue(date.equals(LocalDate.parse("1/02/2017", FORMATTER)));
    }

    @Test
    public void testParseOrdinalFour() {
        LocalDate date = DateUtil.parse("22nd June 2017");
        assertTrue(date.equals(LocalDate.parse("22/06/2017", FORMATTER)));
    }

    @Test
    public void testParseNullValue() {
        assertNull(DateUtil.parse(""));
        assertNull(DateUtil.parse(null));
    }
}
