package by.epam.makarevich.reader;

import by.epam.makarevich.exception.NoThisFileException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class ReadTextParameterizedTest {
    private String fullFile;
    private String emptyFile;
    private String nonExistentFile;

    public ReadTextParameterizedTest(String fullFile, String emptyFile, String nonExistentFile) {
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
        assertFalse(ReadText.read(fullFile).isEmpty());
    }

    @Test(expected = NoThisFileException.class)
    public void readNonExistingFile() throws Exception {
        assertTrue(ReadText.read(nonExistentFile).isEmpty());
    }

    @Test
    public void readEmptyFile() throws Exception {
        assertTrue(ReadText.read(emptyFile).isEmpty());
    }

}
