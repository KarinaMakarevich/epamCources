package by.epam.makarevich.util.checkCharacteristic;

import by.epam.makarevich.type.TypeOfPosition;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static by.epam.makarevich.util.checkCharacteristic.CheckAllCharacteristic.checkAllCharacteristic;
import static org.junit.Assert.assertEquals;

public class CheckAllCharacteristicTest {
    private ArrayList<String> lines;
    private String data;

    @Before
    public void initialize() {
        lines = new ArrayList<String>();
        lines.add("Programmer");
        lines.add(" Fedotov Dmitryy");
        lines.add("400$");
        lines.add("8h");
        lines.add("IOS-development");
    }

    @After
    public void cleanData() {
        data = null;
    }

    @Test
    public void checkRightProgrammer() {
        data = checkAllCharacteristic(lines);
        assertEquals(data, TypeOfPosition.PROGRAMMER.toString());
    }


}