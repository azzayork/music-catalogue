package com.azzayork.musiccatalogue.domain;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * @author Aaron York
 * @since 07/10/2017
 */
public class UsageTest {

    private static final String DOWNLOAD = "digital download";

    private static final String STREAMING = "streaming";

    @Test
    public void testForDescription() {

        Usage download = Usage.fromDescription(DOWNLOAD);
        Usage streaming = Usage.fromDescription(STREAMING);

        assertNotNull(download);
        assertNotNull(streaming);
        assertTrue(download.equals(Usage.DOWNLOAD));
        assertTrue(streaming.equals(Usage.STREAMING));
    }

    @Test
    public void testBadDescription() {

        Usage shouldBeNull = Usage.fromDescription("BAD DESCRIPTION");
        assertNull(shouldBeNull);
    }
}
