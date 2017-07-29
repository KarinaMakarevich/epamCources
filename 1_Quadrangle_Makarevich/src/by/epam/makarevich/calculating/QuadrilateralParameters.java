package by.epam.makarevich.calculating;

import by.epam.makarevich.entity.Point;
import org.apache.log4j.Logger;

import java.util.ArrayList;

public class QuadrilateralParameters {
    private static final Logger LOG = Logger.getLogger(QuadrilateralParameters.class);

    public boolean isQuadrilateral(ArrayList<Point> list) {
        Point p1 = list.get(0);
        Point p2 = list.get(1);
        Point p3 = list.get(2);
        Point p4 = list.get(3);
        boolean line1 = (getLine(p1, p2, p3) == 0);
        boolean line2 = (getLine(p2, p3, p4) == 0);
        boolean line3 = (getLine(p4, p1, p2) == 0);
        boolean line4 = (getLine(p1, p3, p4) == 0);
        boolean answer = (!line1) && (!line2) && (!line3) && (!line4);
        if (answer) {
            LOG.info(p1.toString() + p2.toString() + p3.toString() + p4.toString() + " is quadrilateral");
        } else {
            LOG.info(p1.toString() + p2.toString() + p3.toString() + p4.toString() + " isn't quadrilateral");
        }
        return (answer);
    }

    public boolean isConvex(ArrayList<Point> points) {
        Point p1 = points.get(0);
        Point p2 = points.get(1);
        Point p3 = points.get(2);
        Point p4 = points.get(3);
        if (isQuadrilateral(points)) {
            ValuesObserver valuesObserver = new ValuesObserver();
            valuesObserver.square(points);
            double square = valuesObserver.getSquare();
            if ((triangleSquare(p1, p2, p3) < square) && (triangleSquare(p2, p3, p4) < square) && (triangleSquare(p1, p2, p4) < square)) {
                LOG.info(p1.toString() + p2.toString() + p3.toString() + p4.toString() + " is convex");
                return true;
            } else {
                LOG.info(p1.toString() + p2.toString() + p3.toString() + p4.toString() + " isn't convex");
                return false;
            }
        } else {
            LOG.info("Can't be convex, because " + p1.toString() + p2.toString() + p3.toString() + p4.toString() + "isn't quadrilateral");
            return false;
        }
    }

    public boolean isQuadrate(ArrayList<Point> points) {
        Point p1 = points.get(0);
        Point p2 = points.get(1);
        Point p3 = points.get(2);
        Point p4 = points.get(3);
        if (isConvex(points)) {
            double distance12 = getDistance(p1, p2);
            double distance23 = getDistance(p2, p3);
            double distance34 = getDistance(p3, p4);
            double distance41 = getDistance(p4, p1);
            double diagonal13 = getDistance(p1, p3);
            double diagonal24 = getDistance(p2, p4);
            boolean answer = ((distance12 == distance23) == (distance34 == distance41) == (diagonal13 == diagonal24));
            if (answer) {
                LOG.info(p1.toString() + p2.toString() + p3.toString() + p4.toString() + " is quadrate");
            }
            else{
                LOG.info(p1.toString() + p2.toString() + p3.toString() + p4.toString() + " isn't quadrate");
            }
            return (answer);
        } else {
            LOG.info("Can't be quadrate, because " + p1.toString() + p2.toString() + p3.toString() + p4.toString() + "isn't convex");
            return false;
        }
    }

    private double getDistance(Point p1, Point p2) {
        return Math.hypot(p1.getX() - p2.getX(), p1.getY() - p2.getY());
    }

    private double getLine(Point p1, Point p2, Point p3) {
        return ((p1.getX() - p3.getX()) * (p2.getY() - p3.getY())) - ((p1.getY() - p3.getY()) * (p2.getX() - p3.getX()));

    }

    private double partOfSquare(Point mainPoint, Point p2, Point p3) {
        return 0.5 * (getDistance(p2, p3) + getDistance(p3, mainPoint) - getDistance(mainPoint, p2));
    }

    private double triangleSquare(Point p1, Point p2, Point p3) {
        return Math.sqrt(partOfSquare(p1, p2, p3) * partOfSquare(p2, p3, p1) * partOfSquare(p3, p1, p2));
    }

}
