package com.azzayork.musiccatalogue.domain;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Aaron York
 * @since 07/10/2017
 */
public class EffectiveDateTest {


    LocalDate startDate;

    LocalDate endDate;

    EffectiveDate effectiveDate;

    @Before
    public void setUp(){
       startDate = DateUtil.parse("16/06/2017");
       endDate = DateUtil.parse("20/09/2017");
       effectiveDate = new EffectiveDate(startDate, endDate);
    }

    @Test
    public void testDateIsEffective() {
        LocalDate validDate = DateUtil.parse("11/07/2017");
        assertTrue(effectiveDate.isEffective(validDate));
    }

    @Test
    public void testDateBeforeIsNotEffective() {
        LocalDate validDate = DateUtil.parse("1/04/2017");
        assertFalse(effectiveDate.isEffective(validDate));
    }

    @Test
    public void testDateAfterIsNotEffective() {
        LocalDate validDate = DateUtil.parse("29/10/2017");
        assertFalse(effectiveDate.isEffective(validDate));
    }

    @Test
    public void testStartDateIsEffective() {
        assertTrue(effectiveDate.isEffective(startDate));
    }

    @Test
    public void testEndtDateIsEffective() {
        assertTrue(effectiveDate.isEffective(endDate));
    }
}
