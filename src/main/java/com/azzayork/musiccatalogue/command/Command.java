package com.azzayork.musiccatalogue.command;

/**
 * @author Aaron York
 * @since 08/10/2017
 */
public interface Command {

    Result execute(String[] args);
}
