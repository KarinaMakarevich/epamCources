package by.epam.makarevich.calculating;

import by.epam.makarevich.observer.OperationObserver;
import by.epam.makarevich.entity.Point;
import by.epam.makarevich.entity.Quadrilateral;
import org.apache.log4j.Logger;

import java.util.ArrayList;

public class ValuesObserver extends OperationObserver {
    private static final Logger LOG = Logger.getLogger(ValuesObserver.class);
    private double square;
    private double perimeter;

    private double getDistance(Point p1, Point p2) {
        return Math.hypot(p1.getX() - p2.getX(), p1.getY() - p2.getY());
    }

    public void perimeter(ArrayList<Point> points) {
        Point p1 = points.get(0);
        Point p2 = points.get(1);
        Point p3 = points.get(2);
        Point p4 = points.get(3);
        double line1 = getDistance(p1, p2);
        double line2 = getDistance(p2, p3);
        double line3 = getDistance(p3, p4);
        double line4 = getDistance(p1, p4);
        double perimeter = line1 + line2 + line3 + line4;
        LOG.info("Perimeter of quadrilateral " + p1.toString() + p2.toString() + p3.toString() + p4.toString() + " = " + perimeter);
        this.perimeter = perimeter;
    }

    public void square(ArrayList<Point> points) {
        Point p1 = points.get(0);
        Point p2 = points.get(1);
        Point p3 = points.get(2);
        Point p4 = points.get(3);
        double square1 = (p2.getY() - p4.getY()) * (p3.getX() - p1.getX());
        double square2 = (p1.getY() - p3.getY()) * (p2.getX() - p4.getX());
        double square = 0.5 * Math.abs(square1 + square2);
        LOG.info("Square of quadrilateral " + p1.toString() + p2.toString() + p3.toString() + p4.toString() + " = " + square);
        this.square = square;
    }

    public double getSquare() {
        return this.square;
    }

    public double getPerimeter() {
        return this.perimeter;
    }

    public void valueChanged(Quadrilateral observed) {
        ArrayList<Point> list = observed.getList();
        perimeter(list);
        square(list);
    }
}
