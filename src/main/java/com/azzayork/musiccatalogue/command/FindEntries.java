package com.azzayork.musiccatalogue.command;

import com.azzayork.musiccatalogue.domain.Catalogue;
import com.azzayork.musiccatalogue.domain.Entry;

import java.util.List;

/**
 * @author Aaron York
 * @since 08/10/2017
 */
public class FindEntries implements Command {

    @Override
    public Result execute(String[] args) {

        if (args.length != 2) {
            return new Result(false, null);
        }
        String partner = args[0];
        String date = args[1];

        List<Entry> entries = Catalogue.getInstance().findEntries(partner, date);
        return new Result(!entries.isEmpty(), entries);
    }
}
