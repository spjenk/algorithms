import doubleended.queue.Deque;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DequeTest {

    @Test
    public void createDeque() {

        Deque<String> deque = new Deque<>();

        Assert.assertEquals(deque.isEmpty(), true);
        Assert.assertEquals(deque.size(), 0);
    }

    @Test
    public void addFirstToNewDequeTest() {

        Deque<Integer> deque = new Deque<Integer>();

        deque.addFirst(1);

        Assert.assertEquals(deque.isEmpty(), false);
        Assert.assertEquals(deque.size(), 1);
    }

    @Test
    public void addLastToNewDequeTest() {

        Deque<Integer> deque = new Deque<Integer>();

        deque.addLast(1);

        Assert.assertEquals(deque.isEmpty(), false);
        Assert.assertEquals(deque.size(), 1);
    }

    @Test
    public void removeFirstToDequeWithSizeOfOneTest() {

        Deque<Integer> deque = new Deque<Integer>();

        deque.addFirst(1);
        Integer one = deque.removeFirst();

        Assert.assertEquals(deque.isEmpty(), true);
        Assert.assertEquals(deque.size(), 0);
        Assert.assertEquals(one, new Integer(1));
    }

    @Test
    public void removeLastToDequeWithSizeOfOneTest() {

        Deque<Integer> deque = new Deque<Integer>();

        deque.addFirst(1);
        Integer one = deque.removeLast();

        Assert.assertEquals(deque.isEmpty(), true);
        Assert.assertEquals(deque.size(), 0);
        Assert.assertEquals(one, new Integer(1));
    }

    public void multipleAddAndRemoveTest() {
        Deque<String> deque = new Deque<String>();


        deque.addFirst("A");
        deque.addFirst("B");
        deque.addLast("C");
        deque.addLast("E");

        Assert.assertEquals(deque.isEmpty(), false);
        Assert.assertEquals(deque.size(), 4);

        Assert.assertEquals(deque.removeFirst(), "A");
        Assert.assertEquals(deque.removeLast(), "E");
        Assert.assertEquals(deque.size(), 2);

        Assert.assertEquals(deque.removeFirst(), "B");
        Assert.assertEquals(deque.removeFirst(), "C");
        Assert.assertEquals(deque.isEmpty(), true);
        Assert.assertEquals(deque.size(), 0);

    }
}
