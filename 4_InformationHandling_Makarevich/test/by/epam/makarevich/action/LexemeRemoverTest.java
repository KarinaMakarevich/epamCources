package by.epam.makarevich.action;

import by.epam.makarevich.composite.InseparableTextPart;
import by.epam.makarevich.composite.SeparableTextPart;
import by.epam.makarevich.composite.TextPart;
import by.epam.makarevich.type.ComponentType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LexemeRemoverTest {
    TextPart part = new SeparableTextPart();
    @Before
    public void initialize() {
        part.add(new InseparableTextPart("Lorem", ComponentType.WORD));
        part.add(new InseparableTextPart("Lorem", ComponentType.WORD));
        part.add(new InseparableTextPart("Lorem", ComponentType.WORD));
        part.add(new InseparableTextPart("Lor", ComponentType.WORD));
        part.add(new InseparableTextPart("kk", ComponentType.WORD));
        part.add(new InseparableTextPart("5+5", ComponentType.MATH_EXPRESSION));
    }

    @Test
    public void removeLexeme() {
        LexemeRemover lexemeRemover = new LexemeRemover();
        lexemeRemover.removeLexeme(this.part, 5, 'L');
        assertEquals(this.part.getComponentArray().size(), 3);
    }

}