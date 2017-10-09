package com.azzayork.musiccatalogue.domain;

import java.util.List;

/**
 * A simple value object representing an Entry in a Catalogue
 *
 * @author Aaron York
 * @since 07/10/2017
 */
public class Entry {

    private final EffectiveDate effectiveDate;

    private final String artist;

    private final String title;

    private final List<Usage> usage;

    public Entry(EffectiveDate effectiveDate, String artist, String title, List<Usage> usage) {
        this.effectiveDate = effectiveDate;
        this.artist = artist;
        this.title = title;
        this.usage = usage;
    }

    public List<Usage> getUsage() {
        return usage;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public EffectiveDate getEffectiveDate() {
        return effectiveDate;
    }

    public boolean hasPartner(String partner) {
        return usage.stream().filter(u -> u.getPartner().equals(partner)).count() > 0;
    }

}
