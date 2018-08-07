package mergesort;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Problem to solve:
 * Suppose that you have two sorted subarrays.
 * How can you merge the two subarrays using an auxiliary array of length n (instead of 2n)?
 */
public class SmallAuxArray {

    private String[] a;
    private String[] aux;

    public SmallAuxArray(String[] a) {
        this.a = a;
        this.aux = new String[a.length / 2];
    }

    public String[] merge() {

        //only copy left half to auxiliary array
        int mid = a.length/2;
        for(int i = 0; i<mid; i++) {
            aux[i] = a[i];
        }

        //merge
        int left = 0, right = mid;
        for (int i = 0; i < a.length; i++) {
            if (left >= mid) {
                a[i] = a[right++];
            }
            else if (right >= a.length-1) {
                a[i] = aux[left++];
            } else {
                int compare = aux[left].compareTo(a[right]);
                if (compare > 0) {
                    a[i] = a[right++];
                } else if (compare < 0) {
                    a[i] = aux[left++];
                } else if (compare == 0) {
                    a[i++] = a[right++];
                    a[i] = aux[left++];
                }
            }
        }
        return a;
    }

    public String[] getA() {
        return a;
    }

    public String[] getAux() {
        return aux;
    }
}
