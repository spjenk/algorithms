package doubleended.queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Stephen Jenkinson on 02-Feb-17.
 */
public class Deque<Item> implements Iterable<Item> {

    private Node first = null;
    private int size = 0;

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

    public void addFirst(Item item) {
        validateItem(item);
        first = new Node(item, first);
        size++;
    }

    public void addLast(Item item) {
        validateItem(item);

        if (first != null) {
            Node node = first;

            while (node.next != null) {
                node = node.next;
            }

            node.next = new Node(item, null);
        } else {
            first = new Node(item, null);
        }
        size++;
    }

    public Item removeFirst() {
        validateQueueNotEmpty();
        Item item = first.item;
        first = first.next;
        size--;
        return item;
    }

    public Item removeLast() {
        validateQueueNotEmpty();
        Item i = first.item;

        if (first.next == null) {
            first = null;
        } else {

            Node node = first;
            while (node.next.next != null) {
                node = node.next;
            }

            i = node.next.item;
            node.next = null;
        }
        size--;
        return i;
    }

    public Iterator<Item> iterator() {
        return new ItemIterator();
    }

    private void validateItem(Item item) {
        if (item == null) {
            throw new NullPointerException();
        }
    }

    private void validateQueueNotEmpty() {
        if (first == null) {
            throw new NoSuchElementException();
        }
    }

    private class Node {
        Item item;
        Node next;

        public Node(Item item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    private class ItemIterator implements Iterator<Item> {
        Node node = first;

        public boolean hasNext() {
            return node != null;
        }

        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            Item item = node.item;
            node = node.next;
            return item;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
