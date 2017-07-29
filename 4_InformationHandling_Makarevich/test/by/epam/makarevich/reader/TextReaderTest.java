package by.epam.makarevich.reader;

import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class TextReaderTest {
    private String data;

    @Test
    public void readExistingFile() throws Exception {
        data = TextReader.read("resources/files/firstFullInput.txt");
        assertFalse(data.isEmpty());
    }
}
