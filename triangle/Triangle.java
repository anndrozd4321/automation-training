package by.bsu.mmf;

import by.bsu.mmf.TriangleException;

public class Triangle {

    public static boolean triangleFormed(double a, double b, double c) {

        if (a <= 0 || b <= 0 || c <= 0) {
            throw new TriangleException("Side of negative length");
        }

        if (a == 0.0 || b == 0.0 || c == 0.0) {
            throw new TriangleException("Length of side equel zero");
        }

        if (a == Double.POSITIVE_INFINITY || b == Double.POSITIVE_INFINITY || c == Double.POSITIVE_INFINITY) {
            throw new TriangleException("");
        }

        if (Double.compare(a, Double.NaN) * Double.compare(b, Double.NaN) * Double.compare(c, Double.NaN) == 0) {
            throw new TriangleException("");
        }
        return check(a, b, c) && check(a, c, b) && check(b, c, a);
    }

    private static boolean check(double x, double y, double z) {
        return ((x + y) > z);
    }
    
}

