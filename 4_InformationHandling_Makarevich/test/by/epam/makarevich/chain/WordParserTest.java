package by.epam.makarevich.chain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WordParserTest {
    String data = new String("It has survived not only five centuries, but also the leap into 13+ i-- electronic typesetting, remaining 3+5 essentially 6+9*(3-4) unchanged.");
    String firstParagraph = new String("   It has survived not only five centuries, but also the leap into 13+ i-- electronic typesetting, remaining 3+5 essentially 6+9*(3-4) unchanged. It was popularised in the 5*(1*2*(3*(4*(5- --j + 4)-3)-2)-1) with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");

    @Test
    public void parseWord() {
        WordParser wordParser = new WordParser();
        int wordCount = wordParser.parseData(this.firstParagraph).getComponentArray().size();
        assertEquals(wordCount, 51);
    }

    @Test
    public void parseData() {
        WordParser wordParser = new WordParser();
        int wordCount = wordParser.parseData(this.data).getComponentArray().size();
        assertEquals(wordCount, 20);
    }
}