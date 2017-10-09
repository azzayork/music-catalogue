package com.azzayork.musiccatalogue.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * A singleton that holds a list of Entries
 *
 * @author Aaron York
 * @since 07/10/2017
 */
public class Catalogue {

    private static Catalogue instance;


    private List<Entry> entries = new ArrayList<>();

    private Catalogue() { }

    public static Catalogue getInstance() {
        if(instance == null){
            instance = new Catalogue();
        }
        return instance;
    }

    public List<Entry> findEntries(String partner, String date){

        LocalDate searchDate = DateUtil.parse(date);

        return getInstance().entries.stream().filter(entry ->
                entry.hasPartner(partner) && entry.getEffectiveDate().isEffective(searchDate))
                .collect(toList());
    }

    public List<Entry> getEntries() {
        return entries;
    }

    public void setEntries(List<Entry> entries) {
        getInstance().entries = entries;
    }

    public void addEntry(Entry entry) {
        getInstance().entries.add(entry);
    }
}
