package by.epam.makarevich.util;

import by.epam.makarevich.entity.Quadrilateral;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class TextSplittingTest {
    private ArrayList<String> lines;

    @Before
    public void initialize() {
        lines = new ArrayList<String>();
        lines.add("(0;0) (0;1) (1;1) (1;0)");
        lines.add("(kk;0) (0;1) (1;1) (1;0)");
        lines.add("(2;0) (2;1) (1;1) (1;0)");
        lines.add("1;) (0;1) (1;1) (1;0)");
        lines.add("(kk;0) (ll;1) (1;1) (1;0");
        lines.add("2;5) (2;1) (1;1) (1;6");

    }

    @Test
    public void splitData() {
        TextSplitting textSplitting = new TextSplitting();
        ArrayList<Double> list = new ArrayList<Double>();
        list = textSplitting.parseText(lines);
        assertFalse(list.isEmpty());
    }

    @Test
    public void checkSizeOfData() {
        TextSplitting textSplitting = new TextSplitting();
        ArrayList<Double> list = new ArrayList<Double>();
        list = textSplitting.parseText(lines);
        assertEquals(list.size() / Quadrilateral.NEEDED_POINTS_COORDINATES, 3);
    }

    @Test
    public void compareTwoArrays() {
        ArrayList<Double> doubleArrayList = new ArrayList<Double>();
        doubleArrayList.add(0.0);
        doubleArrayList.add(0.0);
        doubleArrayList.add(0.0);
        doubleArrayList.add(1.0);
        doubleArrayList.add(1.0);
        doubleArrayList.add(1.0);
        doubleArrayList.add(1.0);
        doubleArrayList.add(0.0);
        doubleArrayList.add(2.0);
        doubleArrayList.add(0.0);
        doubleArrayList.add(2.0);
        doubleArrayList.add(1.0);
        doubleArrayList.add(1.0);
        doubleArrayList.add(1.0);
        doubleArrayList.add(1.0);
        doubleArrayList.add(0.0);
        doubleArrayList.add(2.0);
        doubleArrayList.add(5.0);
        doubleArrayList.add(2.0);
        doubleArrayList.add(1.0);
        doubleArrayList.add(1.0);
        doubleArrayList.add(1.0);
        doubleArrayList.add(1.0);
        doubleArrayList.add(6.0);
        ArrayList<Double> list = new ArrayList<Double>();
        TextSplitting textSplitting = new TextSplitting();
        list = textSplitting.parseText(lines);
        assertEquals(list, doubleArrayList);
    }
}