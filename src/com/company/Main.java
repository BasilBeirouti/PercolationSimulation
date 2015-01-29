package com.company;

public class Main {

    public static void main(String[] args) {
        Percolation Bob = new Percolation(10);
        Bob.open(1,2);
        Bob.open(2,2);
        Bob.open(3,2);
        Bob.open(4,2);
        Bob.open(5,2);
        Bob.open(6,2);
        Bob.open(7,2);
        Bob.open(8,2);
        Bob.open(8,3);
        Bob.open(9,3);
        Bob.open(10,3);
        boolean b= Bob.percolates();
        boolean c= Bob.isOpen(10,3);
        System.out.println(b);
        System.out.println(c);
        PercolationStats Tim = new PercolationStats(200,200);
        int d=Tim.thresholds.length;
        StdOut.println("mean is " + Tim.mean() + " with confidence interval from " + Tim.confidenceLo() + " to " + Tim.confidenceHi());
    }
}


