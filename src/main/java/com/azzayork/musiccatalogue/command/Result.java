package com.azzayork.musiccatalogue.command;

import com.azzayork.musiccatalogue.domain.Entry;

import java.util.List;

/**
 * @author Aaron York
 * @since 08/10/2017
 */
public class Result {

    private final Boolean success;

    private final List<Entry> data;

    public Result(Boolean success, List<Entry> data) {
        this.success = success;
        this.data = data;
    }

    public Boolean getSuccess() {
        return success;
    }

    public List<Entry> getData() {
        return data;
    }

}
