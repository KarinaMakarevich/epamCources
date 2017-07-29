package by.epam.makarevich;

import by.epam.makarevich.action.EmployeeSorterTest;
import by.epam.makarevich.action.ManHourFinderTest;
import by.epam.makarevich.creator.EmployeeTeamCreatorTest;
import by.epam.makarevich.reader.ReadCharacteristicParametrizedTest;
import by.epam.makarevich.reader.ReadCharacteristicTest;
import by.epam.makarevich.util.checkCharacteristic.CheckAllCharacteristicTest;
import by.epam.makarevich.util.checkCharacteristic.SplitCharacteristicTest;
import junit.framework.TestCase;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@Suite.SuiteClasses({ReadCharacteristicParametrizedTest.class, ReadCharacteristicTest.class,
        SplitCharacteristicTest.class, CheckAllCharacteristicTest.class, ManHourFinderTest.class,
        EmployeeSorterTest.class, EmployeeTeamCreatorTest.class})
@RunWith(Suite.class)
public class TestItFirm extends TestCase {
}
