package doubleended.queue;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Stephen Jenkinson on 02-Feb-17.
 */
public class RandomizedQueue<Item> implements Iterable<Item> {

    private static final int DEFAULT_START_SIZE = 1;

    private Item[] items;
    private int size = 0;

    public RandomizedQueue() {
        items = (Item[]) new Object[DEFAULT_START_SIZE];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void enqueue(Item item) {
        if (item == null) throw new NullPointerException();

        if (size == items.length) {
            resize(2 * items.length);
        }
        items[size++] = item;
    }

    public Item dequeue() {
        validateQueueIsNotEmpty();

        int index = StdRandom.uniform(0, size);
        Item item = items[index];
        items[index] = items[--size];
        items[size] = null;

        if (size > 0 && size == items.length / 4) {
            resize(items.length / 2);
        }

        return item;
    }

    public Item sample() {
        validateQueueIsNotEmpty();
        return items[StdRandom.uniform(size)];
    }

    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    private void resize(int capacity) {
        Item[] copy = (Item[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            copy[i] = items[i];
        }
        items = copy;
    }

    private void validateQueueIsNotEmpty() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException();
        }
    }

    public static void main(String[] args) {

        RandomizedQueue<String> queue = new RandomizedQueue<String>();

        System.out.println("Empty?:" + queue.isEmpty());
        System.out.println("Size:" + queue.size());

        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        queue.enqueue("E");
        for (String s : queue) {
            System.out.println(s);
        }
        System.out.println("Empty?:" + queue.isEmpty());
        System.out.println("Size:" + queue.size());

        System.out.println("Sample:" + queue.sample());
        System.out.println("Sample:" + queue.sample());
        System.out.println("Empty?:" + queue.isEmpty());
        System.out.println("Size:" + queue.size());

        System.out.println("removed: " + queue.dequeue());
        System.out.println("removed: " + queue.dequeue());
        for (String s : queue) {
            System.out.println(s);
        }
        System.out.println("Size:" + queue.size());

        queue.dequeue();
        queue.dequeue();
        for (String s : queue) {
            System.out.println(s);
        }
        System.out.println("Empty?:" + queue.isEmpty());
        System.out.println("Size:" + queue.size());
    }

    private class ReverseArrayIterator implements Iterator<Item> {
        private int i;

        public ReverseArrayIterator() {
            i = size -1;
        }

        public boolean hasNext() {
            return i >= 0;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            return items[i--];
        }
    }
}
