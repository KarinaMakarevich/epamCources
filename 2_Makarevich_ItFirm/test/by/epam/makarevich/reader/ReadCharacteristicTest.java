package by.epam.makarevich.reader;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ReadCharacteristicTest {
    private ArrayList<String> characteristic;

    @Before
    public void initialize() {
        characteristic = new ArrayList<String>();
    }

    @After
    public void cleanArray() {
        characteristic.clear();
    }

    @Test
    public void readExistingFile() throws Exception {
        characteristic = ReadCharacteristic.read("resources/files/firstFullInput.txt");
        assertFalse(characteristic.isEmpty());
    }

    @Test
    public void readCheckExistingFile() throws Exception {
        characteristic = ReadCharacteristic.read("resources/files/firstFullInput.txt");
        assertEquals(characteristic.size(), 3);
    }

    @Test(expected = RuntimeException.class)
    public void readWithoutFile() throws Exception {
        characteristic = ReadCharacteristic.read("jjjj");
        assertTrue(characteristic.isEmpty());
    }
}