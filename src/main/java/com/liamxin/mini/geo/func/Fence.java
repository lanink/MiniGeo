package com.liamxin.mini.geo.func;

import com.liamxin.mini.geo.model.base.Point;
import com.liamxin.mini.geo.model.base.Polygon;

/**
 * Fence
 *
 * @author 还不如一只猪威武 <liamxin@yeah.net>
 * @version 0.1
 * @since 2020/4/30 3:41 下午
 */

public class Fence {

    public static boolean isOut(Point point, Polygon polygon) {
        return !isIn(point, polygon);
    }

    public static boolean isIn(Point point, Polygon polygon) {
        if (null == point || null == polygon) {
            throw new RuntimeException("point or polygon is empty");
        }
        return isInPolygon(point, polygon.getVertexes());
    }

    private static boolean isInPolygon(Point p, Point[] v) {
        final boolean boundOrVertex = true;
        final double precision = 2e-10;
        final int N = v.length;
        int c = 0;
        Point p1 = v[0], p2;
        for (int i = 0; i <= N; ++i) {
            if (p.equals(p1)) return boundOrVertex;
            p2 = v[i % N];
            if (p.getX() < Math.min(p1.getX(), p2.getX()) || p.getX() > Math.max(p1.getX(), p2.getX())) continue;
            if (p.getX() > Math.min(p1.getX(), p2.getX()) && p.getX() < Math.max(p1.getX(), p2.getX())) {
                if (p.getY() <= Math.max(p1.getY(), p2.getY())) {
                    if (p1.getX() == p2.getX() && p.getY() > Math.min(p1.getY(), p2.getY()))
                        return boundOrVertex;
                }
                if (p1.getY() == p2.getY()) {
                    if (p.getY() == p1.getY()) return boundOrVertex;
                    ++c;
                } else {
                    double x = (p1.getX() - p2.getX()) / (p1.getY() - p2.getY()) * (p.getY() - p1.getY()) + p1.getX();
                    if (Math.abs(p.getX() - x) < precision) return boundOrVertex;
                    if (p.getX() < x) ++c;
                }
            } else {
                if (p.getX() == p2.getX() && p.getY() <= p2.getY()) {
                    Point p3 = v[(i + 1) % N];
                    if (p.getX() >= Math.min(p1.getX(), p3.getX()) && p.getX() <= Math.max(p1.getX(), p3.getX())) ++c;
                }
            }
            p1 = p2;
        }
        return c % 2 != 0;
    }
}
