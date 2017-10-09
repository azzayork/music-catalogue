package com.azzayork.musiccatalogue.data;

import com.azzayork.musiccatalogue.domain.Entry;
import org.junit.Test;

import java.io.File;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * @author Aaron York
 * @since 08/10/2017
 */
public class DataFileReaderTest {

    @Test
    public void testReadDataFile() throws Exception {
        File testFile = new File(getClass().getClassLoader().getResource("test-data.txt").getFile());
        List<Entry> entries = DataFileReader.readDataFile(testFile);
        assertTrue(entries.size() == 7);
    }
}
