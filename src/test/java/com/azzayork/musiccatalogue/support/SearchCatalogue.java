package com.azzayork.musiccatalogue.support;

import com.azzayork.musiccatalogue.command.FindEntries;
import com.azzayork.musiccatalogue.command.Result;
import com.azzayork.musiccatalogue.domain.DateUtil;
import com.azzayork.musiccatalogue.domain.EffectiveDate;
import com.azzayork.musiccatalogue.domain.Entry;
import com.azzayork.musiccatalogue.domain.Usage;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * @author Aaron York
 * @since 08/10/2017
 */
@Component
@Scope("cucumber-glue")
public class SearchCatalogue {

    private Result result;

    public void searchCatalogue(String partner, String date) {
        String[] args = {partner, date};
        FindEntries findEntries = new FindEntries();
        result = findEntries.execute(args);
    }

    public Result getResult() {
        return result;
    }

    public List<Entry> getEntriesForExpectedData(List<Map<String, String>> data) {
        return data.stream().map(line ->
                new Entry(new EffectiveDate(DateUtil.parse(line.get("StartDate"))
                , DateUtil.parse(line.get("endDate")))
                , line.get("Artist")
                , line.get("Title")
                , Stream.of(Usage.fromDescription(line.get("Usages"))).collect(toList())))
                .collect(toList());
    }
}
