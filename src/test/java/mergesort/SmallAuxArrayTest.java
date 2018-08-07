package mergesort;

import mergesort.SmallAuxArray;
import org.junit.Test;
import org.junit.Assert;

public class SmallAuxArrayTest {

    @Test
    public void testAuxSize() {
        SmallAuxArray sar = new SmallAuxArray(new String[]{"a", "c", "e", "g", "b", "d", "f", "h"});
        Assert.assertEquals(sar.getAux().length, 4);
    }

    @Test
    public void testAuxArray() {
        SmallAuxArray sar = new SmallAuxArray(new String[]{"a", "b", "c", "d", "e", "f", "g", "h"});
        sar.merge();
        Assert.assertArrayEquals(sar.getAux(), new String[]{"a", "b", "c", "d"});
    }

    @Test
    public void testMerge() {
        String[] a = {"a", "c", "e", "g", "b", "d", "f", "h"};
        SmallAuxArray sar = new SmallAuxArray(a);
        sar.merge();
        Assert.assertArrayEquals(sar.getA(), new String[]{"a", "b", "c", "d", "e", "f", "g", "h"});
    }

    @Test
    public void testMergeWithDups() {
        String[] a = {"a", "a", "e", "g", "a", "f", "f", "h"};
        SmallAuxArray sar = new SmallAuxArray(a);
        sar.merge();
        Assert.assertArrayEquals(sar.getA(), new String[]{"a", "a", "a", "e", "f", "f", "g", "h"});
    }
}