package com.azzayork.musiccatalogue.domain;

/**
 * Usage possibilities for an Entry.
 *
 * @author Aaron York
 * @since 07/10/2017
 */
public enum Usage {

    DOWNLOAD("digital download", "ITunes"), STREAMING("streaming", "YouTube");

    private final String description;

    private final String partner;

    Usage(String description, String partner) {
        this.description = description;
        this.partner = partner;
    }

    public String getDescription() {
        return description;
    }

    public String getPartner() {
        return partner;
    }

    /**
     * Gets the usage for the description
     *
     * @param description the description
     * @return the usage, or null if one cannot be found
     */
    public static Usage fromDescription(String description){
        for (Usage usage : Usage.values()) {
            if (usage.getDescription().contains(description)) {
                return usage;
            }
        }
        return null;
    }

}
