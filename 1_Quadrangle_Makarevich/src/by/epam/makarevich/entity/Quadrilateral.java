package by.epam.makarevich.entity;

import by.epam.makarevich.calculating.QuadrilateralParameters;
import by.epam.makarevich.observer.OperationObserver;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Iterator;

public class Quadrilateral {
    private static final Logger LOG = Logger.getLogger(Quadrilateral.class);
    public static final int NEEDED_POINTS_COORDINATES = 8;
    private ArrayList<Point> list = new ArrayList<>();
    private ArrayList<OperationObserver> observerList = new ArrayList<>();

    public ArrayList<Point> getList() {
        return this.list;
    }

    public Quadrilateral addPoints(Point p1, Point p2, Point p3, Point p4){
        this.list.add(p1);
        this.list.add(p2);
        this.list.add(p3);
        this.list.add(p4);
        return this;
    }

   public void addObserver(OperationObserver observer) {
        observerList.add(observer);
    }

    public void changePoint(Point p, double x, double y, ArrayList<Point> points) {
        int index = 0;
        for (int i = 0; i < points.size(); ++i) {
            if (points.get(i).getX() == p.getX() && points.get(i).getY() == p.getY())
                index = i;
        }
        Point point = new Point(x, y);
        Point oldPoint = new Point(points.get(index).getX(), points.get(index).getY());
        points.set(index, point);
        QuadrilateralParameters check = new QuadrilateralParameters();
        if (check.isQuadrilateral(points)) {
            this.list = points;
            LOG.info("Can change coordinate " + oldPoint.toString() + " => change it to" + point.toString());
            notifyObservers();
        } else {
            LOG.info("Can't change coordinate " + oldPoint.toString() + " => do nothing");
            points.set(index, oldPoint);
            this.list = points;
            notifyObservers();
        }
    }

    private void notifyObservers() {
        Iterator it = observerList.iterator();
        while (it.hasNext()) {
            ((OperationObserver) it.next()).valueChanged(this);
        }
    }
}

