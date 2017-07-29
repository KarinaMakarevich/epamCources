package by.epam.makarevich.entity;

import by.epam.makarevich.calculating.QuadrilateralParameters;
import by.epam.makarevich.calculating.ValuesObserver;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class QuadrilateralTest {
    private ArrayList<Point> list;
    private QuadrilateralParameters quadrilateralParameters;
    private Quadrilateral quadrilateral;

    @Before
    public void initialize() {
        quadrilateralParameters = new QuadrilateralParameters();
        quadrilateral = new Quadrilateral();
        list = new ArrayList<Point>();
        list.add(new Point(2.02, 1.02));
        list.add(new Point(1.5, 4.15));
        list.add(new Point(5.3, 6.1));
        list.add(new Point(14.25, 6.13));
        quadrilateral.addPoints(new Point(2.02, 1.02), new Point(1.5, 4.15), new Point(5.3, 6.1), new Point(14.25, 6.13));
    }

    @Test
    public void check() {
        assertTrue(quadrilateralParameters.isQuadrilateral(list));
    }

    @Test
    public void changeCoordinate() {
        quadrilateral.addObserver(new ValuesObserver());
        quadrilateral.changePoint(new Point(2.02, 1.02), 1.0, 0.0, list);
        quadrilateral.changePoint(new Point(1.5, 4.15), 1.0, 0.0, list);
        assertTrue(quadrilateralParameters.isQuadrilateral(list));
    }
}