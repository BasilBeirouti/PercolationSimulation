package Basil.PercolationThreshold;

/**
 * Created by basilbeirouti on 1/26/15.
 */
public class PercolationStats {

    private Percolation Test;
    private int N;
    public double[] thresholds;

    //performs T independent experiments on NxN grid
    public static void main(String[] args){
        try {
            int N = Integer.parseInt(args[0]);
            int T = Integer.parseInt(args[1]);
            PercolationStats trial= new PercolationStats(N,T);
            StdOut.println("mean is " + trial.mean() + " with confidence interval from "
                    + trial.confidenceLo() + " to " + trial.confidenceHi());
        }
        catch (NumberFormatException nfe) {
            //one or both of the command line arguments are not integers. Print error and exit with error code 1
            System.exit(1);
        }
    }

    public PercolationStats(int N, int T) {
        if (N<0 || T<0){
            throw new IllegalArgumentException();
        }
        this.N = N;
        this.thresholds = new double[T];
        for (int i = 0; i < T; i++) {
            this.thresholds[i] = this.DoTest(N);
        }
    }


    private double DoTest(int N) {
        this.Test = new Percolation(N);
        double numopen=0;
        //if the system hasn't percolated yet, choose a random site and open it, if it wasn't already open, increment numopen
        while (!Test.percolates()){
            numopen+=this.OpenRandom()? 1 : 0;
        }
        return (numopen/(N*N));
    }

    private boolean OpenRandom() {
        int i=StdRandom.uniform(1,N+1);
        int j=StdRandom.uniform(1,N+1);
        if (!this.Test.isOpen(i,j)) {
            this.Test.open(i, j);
            return true;
        }
        return false;
    }

    public double mean() {
        return StdStats.mean(this.thresholds);
    }

    public double stddev() {
        return StdStats.stddev(this.thresholds);
    }

    public double confidenceLo() {
        return (this.mean()-1.96*this.stddev()/Math.sqrt(this.thresholds.length));
    }

    public double confidenceHi() {
        return (this.mean()+1.96*this.stddev()/Math.sqrt(this.thresholds.length));
    }
}
