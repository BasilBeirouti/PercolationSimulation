# PercolationSimulation
A module that simulates the 2D square lattice site percolation problem

The general problem of percolation is of considerable utility in modeling real world phenomena such as
the fluid flow in porous materials, and thermal and electrical conductivity. Consider an NxN lattice
with each element representing a site that can either be "open" or "closed". Such a system is said to
"percolate" when there is a continuous path of open sites connecting the top of the grid to the bottom.

The question then arises of what proportion of open sites 0<p<1 is required for a given system to be more 
likely than not to percolate? This is called the percolation threshold. While this problem is succinctly
stated and well defined, an analytical solution expressing this proportion has eluded researchers. 
Therefore, numerical simulations are necessary to compute this and other properties of an idealized
percolation system. 

This module provides an algorithm with time complexity proportional to **nlog\*(n)**, where **log\*n** is the 
iterated logarithm function. The Percolation class uses a Union-Find implementation on the back end to 
assess whether a given system percolates. PercolationStats runs T repeated simulations of NxN percolation
systems to compute an estimate of percolation threshold, which has been found to be independent of
N, and equal to about 0.593.
