package by.epam.makarevich.action;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LexemeReplacerTest {
    private String sentence;
    private String auxiliaryData;

    @Before
    public void initialize() {
        sentence = "Hello, my name is Karina, i am a student!";
        auxiliaryData = "student!my name is Karina, i am a Hello, ";
    }

    @Test
    public void replaceLexeme() {
        LexemeReplacer lexemeReplacer = new LexemeReplacer();
        assertEquals(lexemeReplacer.replaceFirstAndLastLexeme(sentence), auxiliaryData);
    }

}