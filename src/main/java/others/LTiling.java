package others;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lan Xiao
 */
public class LTiling {
    private class Point {
        int x, y;
        public Point(int x, int y) {
            this.x = x; this.y = y;
        }
    }

    private class LBracket {
        Point[] points = new Point[3];

        public LBracket(Point a, Point b, Point c) {
            this.points[0] = a;
            this.points[1] = b;
            this.points[2] = c;
        }

        public LBracket(List<Point> points) {
            this.points = points.toArray(this.points);
        }
    }

    private LTiling() {}

    /**
     * This method produces a list of L-bracket that can tile a two-D floor
     */
    public List<LBracket> solve(int n) {
        if (n < 0) throw new IllegalArgumentException();
        int len = (int)Math.pow(2, n);
        List<LBracket> list = new ArrayList<LBracket>();
        for (int i = 2; i <= len; i *= 2) {
            if (i > 2) {
                List<LBracket> list1 = getList1(list, i);
                List<LBracket> list2 = getList2(list, i);
                List<LBracket> list3 = getList3(list, i);
                list.addAll(list1);
                list.addAll(list2);
                list.addAll(list3);

            }
            Point a = new Point(i / 2, i / 2);
            Point b = new Point(i / 2 - 1, i / 2);
            Point c = new Point(i / 2, i / 2 - 1);
            list.add(new LBracket(a, b, c));
        }
        return list;
    }

    static public void main(String[] args) {
        LTiling tiling = new LTiling();
        int n = 4, len = (int)Math.pow(2, n);
        int[][] floor = new int[len][len];
        List<LBracket> list = tiling.solve(n);
        int count = 1;
        for (LBracket bracket : list) {
            for (Point point : bracket.points) {
                floor[point.x][point.y] = count;
            }
            count++;
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                System.out.printf("%2d ", floor[i][j]);
            }
            System.out.println();
        }
    }

    private List<LBracket> getList1(List<LBracket> list, int len) {
        List<LBracket> list1 = new ArrayList<LBracket>();
        int offset = len / 2;
        for (LBracket bracket : list) {
            bracket = invert(bracket, false, true);
            bracket = translate(bracket, offset, offset - 1);
            list1.add(bracket);
        }
        return list1;
    }

    private List<LBracket> getList2(List<LBracket> list, int len) {
        List<LBracket> list2 = new ArrayList<LBracket>();
        int offset = len / 2;
        for (LBracket bracket : list) {
            bracket = invert(bracket, true, false);
            bracket = translate(bracket, offset - 1, offset);
            list2.add(bracket);
        }
        return list2;
    }

    /**
     * This returns a translation of the L-bracket
     * @return a list of brackets in the bottom right quadrant
     */
    private List<LBracket> getList3(List<LBracket> list, int len) {
        List<LBracket> list3 = new ArrayList<LBracket>();
        int offset = len / 2;
        for (LBracket bracket : list) {
            list3.add(translate(bracket, offset, offset));
        }
        return list3;
    }

    private LBracket translate(LBracket bracket, int offsetX, int offsetY) {
        List<Point> points = new ArrayList<Point>();
        for (Point point : bracket.points) {
            points.add(new Point(point.x + offsetX, point.y + offsetY));
        }
        return new LBracket(points);
    }

    private LBracket invert(LBracket bracket, boolean invertX, boolean invertY) {
        List<Point> points = new ArrayList<Point>();
        for (Point point : bracket.points) {
            Point p = new Point(point.x, point.y);
            if (invertX) p.x = -p.x;
            if (invertY) p.y = -p.y;
            points.add(p);
        }
        return new LBracket(points);
    }
}