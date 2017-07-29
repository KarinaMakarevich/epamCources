package by.epam.makarevich.chain;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParagraphParserTest {
    private String data;
    private String auxiliaryData;

    @Before
    public void initialize() {
        this.data = new String("    It has survived not only five centuries, but also the leap into 13+ i-- electronic typesetting, remaining 3+5 essentially 6+9*(3-4) unchanged. It was popularised in the 5*(1*2*(3*(4*(5- --j + 4)-3)-2)-1) with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.\n" +
                "    It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using (71-(2*i--*(3*(2-1/2*2)2)-10/2))*++i Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English.\n" +
                "    It is a (-5+1/2*(2+5*2- --j))*1200 established fact that a reader will be of a page when looking at its layout.");
        this.auxiliaryData = new String("    It has survived not only five centuries, but also the leap into 13+ i-- electronic typesetting, remaining 3+5 essentially 6+9*(3-4) unchanged. It was popularised in the 5*(1*2*(3*(4*(5- --j + 4)-3)-2)-1) with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.\n" +
                "    It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using (71-(2*i--*(3*(2-1/2*2)2)-10/2))*++i Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English.\n" +
                "    It is a (-5+1/2*(2+5*2- --j))*1200 established fact that a reader will be of a page when looking at its layout.");
    }

    @Test
    public void checkParagraphParse() {
        ParagraphParser paragraphParser = new ParagraphParser();
        assertEquals(paragraphParser.parseData(data).getTextPart(), this.auxiliaryData);
    }

    @Test
    public void countParagraph() {
        ParagraphParser paragraphParser = new ParagraphParser();
        int paragraphCount = paragraphParser.parseData(data).getComponentArray().size();
        assertEquals(paragraphCount, 3);
    }
}