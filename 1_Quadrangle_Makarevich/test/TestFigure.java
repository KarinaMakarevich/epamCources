import by.epam.makarevich.calculating.QuadrilateralParametersTest;
import by.epam.makarevich.calculating.ValuesObserverTest;
import by.epam.makarevich.entity.QuadrilateralTest;
import by.epam.makarevich.reader.ReadTextParameterizedTest;
import by.epam.makarevich.reader.ReadTextTest;
import by.epam.makarevich.util.TextSplittingTest;
import junit.framework.TestCase;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@Suite.SuiteClasses({ReadTextTest.class, TextSplittingTest.class, ReadTextParameterizedTest.class,
        QuadrilateralParametersTest.class, QuadrilateralTest.class, ValuesObserverTest.class})
@RunWith(Suite.class)

public class TestFigure extends TestCase {

}

