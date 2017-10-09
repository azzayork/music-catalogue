package com.azzayork.musiccatalogue.domain;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertTrue;

/**
 * @author Aaron York
 * @since 07/10/2017
 */
public class CatalogueTest {

    @Before
    public void setUp() {

        Entry entry1 = new Entry(effectiveDate("1/01/2017", "3/02/2017")
                , "Mr Jones"
                , "Best of Mr Jones"
                , Stream.of(Usage.DOWNLOAD, Usage.STREAMING).collect(toList()));


        Entry entry2 = new Entry(effectiveDate("15/07/2017", "3/12/2017")
                , "Mr Smith"
                , "Best of Mr Smith"
                , Stream.of(Usage.STREAMING).collect(toList()));

        Entry entry3 = new Entry(effectiveDate("17/08/2017", "13/02/2018")
                , "Mr Smith"
                , "More Great Songs"
                , Stream.of(Usage.DOWNLOAD).collect(toList()));

        Stream.of(entry1, entry2, entry3).forEach( e -> Catalogue.getInstance().addEntry(e));
    }

    @Test
    public void testFindEntries() {
        List<Entry> result = Catalogue.getInstance().findEntries("YouTube", "23/11/2017");
        assertTrue(result.size() == 1  );
        result.stream().forEach(entry -> assertTrue(entry.getArtist().equals("Mr Smith")));

        result = Catalogue.getInstance().findEntries("ITunes", "1/02/2017");
        assertTrue(result.size() == 1  );
        result.stream().forEach(entry -> assertTrue(entry.getArtist().equals("Mr Jones")));

        result = Catalogue.getInstance().findEntries("ITunes", "3/01/2018");
        assertTrue(result.size() == 1  );
        result.stream().forEach(entry -> assertTrue(entry.getArtist().equals("Mr Smith")));
    }

    private EffectiveDate effectiveDate(String start, String end) {
        LocalDate startDate = DateUtil.parse(start);
        LocalDate endDate = DateUtil.parse(end);

        return new EffectiveDate(startDate, endDate);
    }
}
