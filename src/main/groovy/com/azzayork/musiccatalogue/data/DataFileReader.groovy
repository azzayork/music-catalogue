package com.azzayork.musiccatalogue.data

import com.azzayork.musiccatalogue.domain.DateUtil
import com.azzayork.musiccatalogue.domain.EffectiveDate
import com.azzayork.musiccatalogue.domain.Entry
import com.azzayork.musiccatalogue.domain.Usage

import static com.xlson.groovycsv.CsvParser.parseCsv
/**
 * @author Aaron York
 * @since 08/10/2017
 */
class DataFileReader {

    static List<Entry> readDataFile(File file) throws FileNotFoundException {

        Iterator data = parseCsv(new FileReader(file), separator: '|')
        List<Entry> entries = data?.collect { line ->
            String startDate = line.StartDate
            String endDate = line.EndDate

            String lineUsages = line.Usages

            List<Usage> usages = lineUsages?.tokenize(',').collect { description ->
                Usage.fromDescription(description.trim())
            }
            Entry entry = new Entry(new EffectiveDate(DateUtil.parse(startDate), DateUtil.parse(endDate)), line.Artist, line.Title, usages)
            entry
        }
        entries
    }
}
