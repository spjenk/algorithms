package weightedquickunion.percolation;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

/**
 * Created by Stephen Jenkinson on 27-Jan-17.
 */
public class PercolationStats {

    private double[] fractions;
    private int trials;

    public PercolationStats(int n, int trials) {
        // perform trials independent experiments on an n-by-n grid
        if (n <= 0 || trials <= 0) {
            throw new IllegalArgumentException("n and trials must be greater than zero");
        }

        fractions = new double[trials];
        this.trials = trials;

        for (int i = 0; i < trials; i++) {
            Percolation p = new Percolation(n);

            while (!p.percolates()) {
                p.open(StdRandom.uniform(1, n + 1), StdRandom.uniform(1, n + 1));
            }

            this.fractions[i] = (double) p.numberOfOpenSites() / (double) (n * n);
        }
    }

    public double mean() {
        return StdStats.mean(fractions);
    }

    public double stddev() {
        return StdStats.stddev(fractions);
    }

    public double confidenceLo() {
       return mean() - (1.96 * (stddev() / Math.sqrt(trials)));
    }

    public double confidenceHi() {
        return mean() + (1.96 * (stddev() / Math.sqrt(trials)));
    }

    public static void main(String[] args) {
        // test client (described below)
        PercolationStats stats = new PercolationStats(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        System.out.println("mean:                   = " + stats.mean());
        System.out.println("stddev:                 = " + stats.stddev());
        System.out.println("95% confidence interval = " + stats.confidenceLo() + ", " + stats.confidenceHi());
    }
}