import org.junit.Assert;
import org.junit.Test;

public class PointTest {

    @Test
    public void horizontalSlopeTest() {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(2, 1);

        Assert.assertEquals(0.0, p1.slopeTo(p2), 0.0);
    }

    @Test
    public void verticalSlopeTest() {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(1, 2);

        Assert.assertEquals(Double.POSITIVE_INFINITY, p1.slopeTo(p2), 0.0);
    }

    @Test
    public void equalSlopeTest() {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(1, 1);

        Assert.assertEquals(Double.NEGATIVE_INFINITY, p1.slopeTo(p2), 0.0);
    }

    @Test
    public void nonRelatedSlopeTest() {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(3, 5);

        Assert.assertEquals(2.0, p1.slopeTo(p2), 0.0);
    }

    /*
    the value <tt>0</tt> if this point is equal to the argument
     *         point (x0 = x1 and y0 = y1);
     *         a negative integer if this point is less than the argument
     *         point; and a positive integer if this point is greater than the
     *         argument point
     */

    @Test
    public void compareEqualPointTest() {
        Point origin = new Point(1, 1);
        Point other = new Point(1, 1);

        Assert.assertEquals(0, origin.compareTo(other));
    }

    @Test
    public void compareLessThanPointTest() {
        Point origin = new Point(1, 1);
        Point other = new Point(1, 2);

        Assert.assertTrue(origin.compareTo(other) < 0);
    }

    public void compareLessThanWithYEqualPointTest() {
        Point origin = new Point(0, 2);
        Point other = new Point(1, 2);

        Assert.assertTrue(origin.compareTo(other) < 0);
    }

    @Test
    public void compareGreaterThanPointTest() {
        Point origin = new Point(1, 2);
        Point other = new Point(1, 1);

        Assert.assertTrue(origin.compareTo(other) > 0);
    }

    @Test
    public void compareGreaterThanWithYEqualPointTest() {
        Point origin = new Point(2, 2);
        Point other = new Point(1, 2);

        Assert.assertTrue(origin.compareTo(other) > 0);
    }
}
