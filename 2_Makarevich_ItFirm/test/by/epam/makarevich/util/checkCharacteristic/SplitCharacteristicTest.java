package by.epam.makarevich.util.checkCharacteristic;

import by.epam.makarevich.util.parsing.SplitCharacteristic;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

public class SplitCharacteristicTest {
    private ArrayList<String> lines;

    @Before
    public void initialize() {
        lines = new ArrayList<String>();
        lines.add("Programmer, Fedotov Dmitryy, 400$, 8 h, IOS-development, junior");
        lines.add("Analyst, Ivanov Ivan Ivanovich, 300$, 6h, java, middle");
        lines.add("Tester, Bihig Kostya Petrovich, 200$, 4h, c#, middle");
        lines.add("Tester, 200$, 4, c#, middle");
        lines.add(" Ivanov Ivan Ivanovich, 300$, 6h, java, middle");
        lines.add("300$, 6h, java, middle");

    }

    @Test
    public void splitData() {
        SplitCharacteristic splitCharacteristic = new SplitCharacteristic();
        ArrayList<String> list = new ArrayList<String>();
        list.addAll(splitCharacteristic.parseText(lines.get(0)));
        list.addAll(splitCharacteristic.parseText(lines.get(1)));
        list.addAll(splitCharacteristic.parseText(lines.get(2)));
        list.addAll(splitCharacteristic.parseText(lines.get(3)));
        list.addAll(splitCharacteristic.parseText(lines.get(4)));
        list.addAll(splitCharacteristic.parseText(lines.get(5)));
        assertEquals(list.size(), 32);
    }
}