package by.epam.makarevich.reader;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class ReadCharacteristicParametrizedTest {
    private String fullFile;
    private String emptyFile;
    private String nonExistentFile;

    public ReadCharacteristicParametrizedTest(String fullFile, String emptyFile, String nonExistentFile) {
        this.fullFile = fullFile;
        this.emptyFile = emptyFile;
        this.nonExistentFile = nonExistentFile;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> initialize() {
        return Arrays.asList(new Object[][]{
                {new String("resources/files/firstFullInput.txt"), new String("resources/files/firstEmptyInput.txt"), new String("hh")},
                {new String("resources/files/secondFullInput.txt"), new String("resources/files/secondEmptyInput.txt"), new String("gg")}
        });
    }

    @Test
    public void readFullFile() throws Exception {
        assertFalse(ReadCharacteristic.read(fullFile).isEmpty());
    }

    @Test(expected = RuntimeException.class)
    public void readNonExistingFile() throws Exception {
        assertTrue(ReadCharacteristic.read(nonExistentFile).isEmpty());
    }

    @Test
    public void readEmptyFile() throws Exception {
        assertTrue(ReadCharacteristic.read(emptyFile).isEmpty());
    }

}
