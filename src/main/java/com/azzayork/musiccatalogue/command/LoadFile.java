package com.azzayork.musiccatalogue.command;

import com.azzayork.musiccatalogue.data.DataFileReader;
import com.azzayork.musiccatalogue.domain.Catalogue;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Optional;

/**
 * @author Aaron York
 * @since 08/10/2017
 */
public class LoadFile implements Command {

    @Override
    public Result execute(String[] args) {

        Optional<String> arg = Arrays.stream(args).findFirst();
        Optional<Result> result = arg.map(fileName -> {
            File file = new File(fileName);
            try {
                Catalogue.getInstance().setEntries(DataFileReader.readDataFile(file));
                return new Result(true, Catalogue.getInstance().getEntries());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            return new Result(false, null);
        });
        return result.orElse(new Result(false, null));
    }
}
