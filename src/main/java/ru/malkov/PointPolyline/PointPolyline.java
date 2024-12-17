package ru.malkov.PointPolyline;

import java.util.List;
import java.util.stream.Collectors;

public class PointPolyline implements IPointPolyline {

    @Override
    public List<Point> processPoints(List<Point> points) {
        return points.stream()
                .distinct()
                .sorted((p1, p2) -> Double.compare(p1.getX(), p2.getX()))
                .map(p -> new Point(p.getX(), Math.abs(p.getY())))
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "PointPolylineStream{}";
    }
}