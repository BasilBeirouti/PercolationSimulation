package PercolationThreshold;

/**
 * Created by basilbeirouti on 1/26/15.
 */

/**
 * in this class, x and y represent 0 indexed row and column numbers respectively,
 * and i and j represent 1 indexed row and column numbers respectively.
 */

public class Percolation {
    private boolean[][] grid;
    private int N;
    private myUF representation;

    //create NxN grid, all sites blocked
    public Percolation(int N) {
        this.N=N;
        grid = new boolean[N][N];
        for (int x = 0; x < N; x++)
            for (int y = 0; y < N; y++)
                grid[x][y] = false;

        representation= new myUF(N*N+2); //creates 1D representation to use unionfind
        for (int y=0; y<N;y++) {
            representation.union(y, N*N); //connect all sites from top row to virtual site above top row, which is the second to last element of representation
            representation.union((N - 1) * N + y, N*N + 1); //connect all sites from bottom row to virtual site below bottom row, which is by convention the last element of representation
        }
    }
    //open site in row i and column j if it's not already open
    public void open(int i, int j) {
        int x = i-1;
        int y = j-1;
        grid[x][y]=true;
        if (x>0){if (grid[x-1][y]){representation.union(x*N+y,(x-1)*N+y);}}
        if (y>0){if (grid[x][y-1]){representation.union(x*N+y,x*N+y-1);}}
        if (x<(N-1)){if (grid[x+1][y]){representation.union(x*N+y,(x+1)*N+y);}}
        if (y<(N-1)){if (grid[x][y+1]){representation.union(x*N+y,x*N+y+1);}}
    }

    //check if site in row i and column j is open
    public boolean isOpen(int i, int j) {
        return grid[i-1][j-1];
    }

    //check if site in row i and column j is connected to any of the top row sites
    public boolean isFull(int i, int j) {
        return representation.connected((i-1)*N+j-1,N*N);
    }
    //check if the NxN system percolates
    public boolean percolates() {
        return representation.connected(N*N,N*N+1);
    }
}