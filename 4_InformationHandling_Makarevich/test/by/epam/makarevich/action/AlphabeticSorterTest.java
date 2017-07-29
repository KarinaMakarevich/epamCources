package by.epam.makarevich.action;

import by.epam.makarevich.composite.InseparableTextPart;
import by.epam.makarevich.composite.SeparableTextPart;
import by.epam.makarevich.composite.TextPart;
import by.epam.makarevich.type.ComponentType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AlphabeticSorterTest {
    private TextPart textPart = new SeparableTextPart();
    private String auxiliaryData;

    @Before
    public void initialize() {
        textPart.add(new InseparableTextPart("Lorem", ComponentType.WORD));
        textPart.add(new InseparableTextPart("5+55", ComponentType.MATH_EXPRESSION));
        textPart.add(new InseparableTextPart("Abra", ComponentType.WORD));
        textPart.add(new InseparableTextPart("haha ", ComponentType.WORD));
        textPart.add(new InseparableTextPart("Karina", ComponentType.WORD));
        textPart.add(new InseparableTextPart("Roma", ComponentType.WORD));
        textPart.add(new InseparableTextPart("Lorum", ComponentType.WORD));
        auxiliaryData = "5+55\n" + "Abra\n" + "Karina\n" + "Lorem; Lorum\n" + "Roma\n";
    }

    @Test
    public void sortAlphabetically() {
        AlphabeticSorter alphabeticSorter = new AlphabeticSorter();
        assertEquals(alphabeticSorter.sortAlphabetically(textPart), auxiliaryData);
    }
}