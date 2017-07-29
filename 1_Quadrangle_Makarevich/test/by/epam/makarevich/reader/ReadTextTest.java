package by.epam.makarevich.reader;

import by.epam.makarevich.exception.NoThisFileException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ReadTextTest {
    private ArrayList<String> coordinates;

    @Before
    public void initialize() {
        coordinates = new ArrayList<String>();
    }

    @After
    public void cleanArray() {
        coordinates.clear();
    }

    @Test
    public void readExistingFile() throws Exception {
        coordinates = ReadText.read("resources/files/firstFullInput.txt");
        assertFalse(coordinates.isEmpty());
    }

    @Test
    public void readCheckExistingFile() throws Exception {
        coordinates = ReadText.read("resources/files/firstFullInput.txt");
        assertEquals(coordinates.size(), 6);
    }

    @Test(expected = NoThisFileException.class)
    public void readWithoutFile() throws Exception {
        coordinates = ReadText.read("jjjj");
        assertTrue(coordinates.isEmpty());
    }
}