package by.epam.makarevich.calculating;

import by.epam.makarevich.entity.Point;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class QuadrilateralParametersTest {
    private QuadrilateralParameters quadParam;
    private ArrayList<Point> firstList;
    private ArrayList<Point> secondList;
    private ArrayList<Point> thirdList;

    @Before
    public void initialize() {
        quadParam = new QuadrilateralParameters();
        firstList = new ArrayList<Point>();
        firstList.add(new Point(0.0, 0.0));
        firstList.add(new Point(0.0, 1.0));
        firstList.add(new Point(1.0, 1.0));
        firstList.add(new Point(1.0, 0.0));
        secondList = new ArrayList<Point>();
        secondList.add(new Point(3.0, 2.0));
        secondList.add(new Point(3.0, 1.0));
        secondList.add(new Point(1.0, 1.0));
        secondList.add(new Point(1.0, 0.0));
        thirdList = new ArrayList<Point>();
        thirdList.add(new Point(1.0, 1.0));
        thirdList.add(new Point(2.0, 2.0));
        thirdList.add(new Point(3.0, 3.0));
        thirdList.add(new Point(4.0, 4.0));
    }

    @Test
    public void isQuadrilateralFirst() {
        assertTrue(quadParam.isQuadrilateral(firstList));
    }

    @Test
    public void isConvexFirst() {
        assertTrue(quadParam.isConvex(firstList));
    }

    @Test
    public void isQuadrateFirst() {
        assertTrue(quadParam.isQuadrate(firstList));
    }

    @Test
    public void isQuadrilateralSecond() {
        assertTrue(quadParam.isQuadrilateral(secondList));
    }

    @Test
    public void isConvexSecond() {
        assertFalse(quadParam.isConvex(secondList));
    }

    @Test
    public void isQuadrateSecond() {
        assertFalse(quadParam.isQuadrate(secondList));
    }

    @Test
    public void isQuadrilateralThird() {
        assertFalse(quadParam.isQuadrilateral(thirdList));
    }

    @Test
    public void isConvexThird() {
        assertFalse(quadParam.isConvex(thirdList));
    }

    @Test
    public void isQuadrateThird() {
        assertFalse(quadParam.isQuadrate(thirdList));
    }
}