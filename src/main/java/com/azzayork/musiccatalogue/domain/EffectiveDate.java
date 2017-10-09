package com.azzayork.musiccatalogue.domain;

import java.time.LocalDate;

/**
 * @author Aaron York
 * @since 07/10/2017
 */
public class EffectiveDate {

    private final LocalDate startDate;

    private final LocalDate endDate;

    public EffectiveDate(LocalDate startDate, LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate != null ? endDate : LocalDate.MAX;
    }

    public boolean isEffective(LocalDate date) {
        return !(date.isBefore(startDate) || date.isAfter(endDate));
    }

}
