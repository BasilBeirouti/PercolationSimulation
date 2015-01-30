package PercolationThreshold;
import PercolationThreshold.extlib.*;

public class Main {

    public static void main(String[] args) {
        PercolationStats Tim = new PercolationStats(200,200);
        int d=Tim.thresholds.length;
        StdOut.println("mean is " + Tim.mean() + " with confidence interval from " + Tim.confidenceLo() + " to " + Tim.confidenceHi());
    }
}


