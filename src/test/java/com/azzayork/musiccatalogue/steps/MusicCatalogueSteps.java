package com.azzayork.musiccatalogue.steps;

import com.azzayork.musiccatalogue.command.LoadFile;
import com.azzayork.musiccatalogue.domain.Entry;
import com.azzayork.musiccatalogue.support.SearchCatalogue;
import cucumber.api.DataTable;
import cucumber.api.java8.En;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * @author Aaron York
 * @since 07/10/2017
 */
public class MusicCatalogueSteps implements En {

    @Autowired
    SearchCatalogue searchCatalogue;

    MusicCatalogueSteps() {
        Given("^the supplied reference data$", () -> {
            String[] args =  {getClass().getClassLoader().getResource("test-data.txt").getFile()};
            LoadFile loadFile = new LoadFile();
            loadFile.execute(args);
        });

        When("^user perform search by (ITunes|YouTube) (\\d{1,2})(st|nd|rd|th)(\\s[a-zA-Z]{3,9}\\s\\d{4})$", (String partner, String dayOfMonth, String ordinal, String date) -> {
            searchCatalogue.searchCatalogue(partner, dayOfMonth + ordinal + date);
        });

        Then("^the output should be$", (DataTable arg1) -> {
            assertTrue(searchCatalogue.getResult().getSuccess());
            assertTrue(searchCatalogue.getResult().getData().size() > 0);

            List<Entry> expectedEntries = searchCatalogue.getEntriesForExpectedData(arg1.asMaps(String.class, String.class));
            //TODO: validate the expectedEntries against the actual entries held in searchCatalogue.result.
        });
    }
}
