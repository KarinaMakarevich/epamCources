package by.epam.makarevich.calculating;

import by.epam.makarevich.entity.Point;
import by.epam.makarevich.entity.Quadrilateral;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class ValuesObserverTest {
    private static final double DELTA = 0.01;
    private ArrayList<Point> points;
    private Quadrilateral quadrilateral;
    private ValuesObserver valuesObserver;

    @Before
    public void initialize() {
        quadrilateral = new Quadrilateral();
        valuesObserver = new ValuesObserver();
        quadrilateral.addPoints(new Point(2.02, 1.02), new Point(1.5, 4.15), new Point(5.3, 6.1), new Point(14.25, 6.13));
        points = new ArrayList<Point>();
        points.add(new Point(2.02, 1.02));
        points.add(new Point(1.5, 4.15));
        points.add(new Point(5.3, 6.1));
        points.add(new Point(14.25, 6.13));
    }

    @Test
    public void checkSquare() {
        quadrilateral.addObserver(valuesObserver);
        quadrilateral.changePoint(new Point(2.02, 1.02), 1.0, 0.0, points);
        double expectedSquare = 34.64;
        assertEquals(valuesObserver.getSquare(), expectedSquare, DELTA);
    }

    @Test
    public void checkPerimeter() {
        quadrilateral.addObserver(valuesObserver);
        quadrilateral.changePoint(new Point(2.02, 1.02), 1.0, 0.0, points);
        double expectedPerimeter = 32.2;
        assertNotEquals(valuesObserver.getPerimeter(), expectedPerimeter, DELTA);
    }
}