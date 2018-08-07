/**
 * Created by spjenk on 11-Feb-17.
 */
public class BruteCollinearPoints {

    private LineSegment lineSegments[];
    private int size = 0;

    public BruteCollinearPoints(Point[] points) {

        lineSegments = new LineSegment[size+1];

        //Corner cases. Throw a java.lang.NullPointerException either the argument to the constructor
        // is null or if any point in the array is null.
        // Throw a java.lang.IllegalArgumentException if the argument to the constructor contains  a repeated point
        for (Point first : points) {
            if (first == null) throw new NullPointerException();
            for (Point second : points) {
                if (first.slopeTo(second) == 1.0) {
                    if (size == lineSegments.length) {
                        resize(lineSegments.length + 1);
                    }
                    lineSegments[size++] = new LineSegment(first, second);
                }
            }
        }
    }

    public int numberOfSegments() {
        return size;
    }

    public LineSegment[] segments() {
        return lineSegments;
    }

    private void resize(int capacity) {
        LineSegment[] copy = (LineSegment[]) new LineSegment[capacity];
        for (int i = 0; i < size; i++) {
            copy[i] = lineSegments[i];
        }
        lineSegments = copy;
    }
}
