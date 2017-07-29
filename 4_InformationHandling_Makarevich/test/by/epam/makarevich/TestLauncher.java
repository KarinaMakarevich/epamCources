package by.epam.makarevich;

import by.epam.makarevich.action.AlphabeticSorterTest;
import by.epam.makarevich.action.ExpressionCalculatorTest;
import by.epam.makarevich.action.LexemeRemoverTest;
import by.epam.makarevich.action.LexemeReplacerTest;
import by.epam.makarevich.chain.ParagraphParserTest;
import by.epam.makarevich.chain.SentenceParserTest;
import by.epam.makarevich.chain.WordParserTest;
import by.epam.makarevich.reader.TextReaderTest;
import junit.framework.TestCase;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@Suite.SuiteClasses({TextReaderTest.class, ParagraphParserTest.class, SentenceParserTest.class, WordParserTest.class,
        LexemeRemoverTest.class, AlphabeticSorterTest.class, ExpressionCalculatorTest.class, LexemeReplacerTest.class})
@RunWith(Suite.class)
public class TestLauncher extends TestCase {
}
