package weightedquickunion.percolation;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/**
 * Created by Stephen Jenkinson on 27-Jan-17.
 */
public class Percolation {

    private static final byte CLOSED = 0;
    private static final byte OPEN = 1;

    private WeightedQuickUnionUF percolatesUf;
    private WeightedQuickUnionUF fullUf;

    private byte[] sites;
    private int size = 0;
    private int openCount = 0;

    private int virtualTop = 0;
    private int virtualBottom = 0;

    public Percolation(int n) {

        if (n <= 0) {
            throw new IllegalArgumentException("n must be greater than 0");
        }

        this.percolatesUf = new WeightedQuickUnionUF(n * n + 2);
        this.fullUf = new WeightedQuickUnionUF(n * n + 2);

        this.sites = new byte[n * n];
        this.size = n;
        this.virtualTop = n * n;
        this.virtualBottom = n * n + 1;
        this.openCount = 0;
    }

    public void open(int row, int col) {
        // open sites (row, col) if it is not open already
        int i = getIndex(row, col);

        if (validateSite(i) && sites[i] == CLOSED) {
            open(i);
            if (col > 1) {
                union(i, i - 1);
            }
            if (col < this.size) {
                union(i, i + 1);
            }
            union(i, i - size);
            union(i, i + size);

            if (row == 1) {
                percolatesUf.union(virtualTop, i);
                fullUf.union(virtualTop, i);
            }

            if (row == this.size) {
                percolatesUf.union(virtualBottom, i);
            }
        }
    }

    public boolean isOpen(int row, int col) {
        return sites[getIndex(row, col)] == OPEN;
    }

    public boolean isFull(int row, int col) {
        return fullUf.connected(getIndex(row, col), virtualTop);
    }

    public int numberOfOpenSites() {
        return this.openCount;
    }

    public boolean percolates() {
        return percolatesUf.connected(virtualTop, virtualBottom);
    }

    private boolean validateSite(int i) {
        return i > -1 && i < sites.length;
    }

    private void union(int i, int neighbour) {
        if (validateSite(neighbour) && sites[neighbour] == OPEN) {
            percolatesUf.union(i, neighbour);
            fullUf.union(i, neighbour);
        }
    }

    private void open(int i) {
        sites[i] = OPEN;
        openCount++;
    }

    private int getIndex(int row, int col) {

        if (row <= 0 || col <= 0 || row > this.size || col > this.size) {
            throw new IndexOutOfBoundsException("Row and Col must be greater than 0");
        }

        return (row - 1) * size + col - 1;
    }

    public static void main(String[] args) {
        // test client (optional)
        Percolation p = new Percolation(5);
        p.open(1, 3);
        System.out.println(p.percolates());
        p.open(1, 4);
        p.open(2, 3);
        p.open(3, 3);
        p.open(4, 3);
        System.out.println(p.percolates());
        p.open(5, 3);
        System.out.println(p.percolates());
    }

}
