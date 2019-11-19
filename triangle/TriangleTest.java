package by.bsu.mmf;

import by.bsu.mmf.TriangleException;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;



public class TriangleTest {

    @DataProvider
    Object[][] zeroSides() {
        return new Double[][] { { 0.0, 5.0, 5.0 }, { 5.0, 0.0, 5.0 }, { 5.0, 5.0, 0.0 }, { 0.0, 0.0, 5.0 },
                { 0.0, 5.0, 0.0 }, { 5.0, 0.0, 0.0 }, { 0.0, 0.0, 0.0 } };
    }

    @DataProvider
    Object[][] negativeSides() {
        return new Double[][] { { -5.0, 5.0, 5.0 }, { 5.0, -5.0, 5.0 }, { 5.0, 5.0, -5.0 }, { -5.0, -5.0, 5.0 },
                { -5.0, 5.0, -5.0 }, { 5.0, 5.0, -5.0 }, { -5.0, -5.0, -5.0 } };
    }

    @DataProvider
    Object[][] naNSides() {
        return new Double[][] { { Double.NaN, 1.0, 1.0 }, { 1.0, Double.NaN, 1.0 }, { 1.0, 1.0, Double.NaN },
                { Double.NaN, Double.NaN, 1.0 }, { Double.NaN, 1.0, Double.NaN }, { 1.0, Double.NaN, Double.NaN },
                {Double.NaN, Double.NaN, Double.NaN } };
    }

    @DataProvider
    Object[][] negativeInfinitySides() {
        return new Double[][] { { Double.POSITIVE_INFINITY, 1.0, 1.0 }, { 1.0, Double.POSITIVE_INFINITY, 1.0 },
                { 1.0, 1.0, Double.POSITIVE_INFINITY }, { Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, 1.0 },
                { Double.POSITIVE_INFINITY, 1.0, Double.POSITIVE_INFINITY }, { 1.0, 1.0, Double.POSITIVE_INFINITY },
                { Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY } };
    }

    @Test
    public void sumOfTwoSidesGreaterThird() {
        Assert.assertTrue(Triangle.TriangleFormed(5.0, 4.0, 3.0));
    }

    @Test
    public void sumOfTwoSidesLessThird() {
        Assert.assertFalse(Triangle.TriangleFormed(5.0, 1.0, 3.0));
    }

    @Test
    public void sumOfTwoSidesEqualsThird() { Assert.assertFalse(Triangle.TriangleFormed(7.0, 4.0, 3.0)); }

    @Test
    public void isoscelesTriangle() { Assert.assertTrue(Triangle.TriangleFormed(10.0, 10.0, 2)); }

    @Test
    public void equilateralTriangle() { Assert.assertTrue(Triangle.TriangleFormed(10.0, 10.0, 10.0)); }

    @Test
    public void rectangularTriangle() { Assert.assertTrue(Triangle.TriangleFormed(13.0, 12.0, 5.0)); }

    @Test
    public void allSidesAreMaxDouble() { Assert.assertTrue(Triangle.TriangleFormed(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE)); }

    @Test
    public void failForIsoscelesTriangle() { Assert.assertFalse(Triangle.TriangleFormed(2.0, 2.0, 5.0)); }

    @Test(dataProvider = "zeroSides", expectedExceptions = { TriangleException.class })
    public void isDeflectZeroSides(Double a, Double b, Double c) {
        Assert.assertFalse(Triangle.TriangleFormed(a, b, c));
    }

    @Test(dataProvider = "negativeSides", expectedExceptions = { TriangleException.class })
    public void isDeflectNegativeSides(Double a, Double b, Double c) {
        Assert.assertFalse(Triangle.TriangleFormed(a, b, c));
    }

    @Test(dataProvider = "naNSides", expectedExceptions = { TriangleException.class })
    public void isDeflectNaNSides(Double a, Double b, Double c) {
        Assert.assertFalse(Triangle.TriangleFormed(a, b, c));
    }

    @Test(dataProvider = "positiveInfinitySides", expectedExceptions = { TriangleException.class })
    public void isDeflectPositiveInfinitySides(Double a, Double b, Double c) {
        Assert.assertFalse(Triangle.TriangleFormed(a, b, c));
    }
}
