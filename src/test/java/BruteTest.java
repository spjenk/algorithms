import org.junit.Assert;
import org.junit.Test;

/**
 * Created by spjenk on 11-Feb-17.
 */
public class BruteTest {

    @Test
    public void diaginalSegmentTest() {
        Point points[] = {new Point(1, 1), new Point(2, 2), new Point(3, 5)};

        BruteCollinearPoints brute = new BruteCollinearPoints(points);

        Assert.assertEquals(1, brute.numberOfSegments());
        Assert.assertEquals(1, brute.segments().length);
    }
}
