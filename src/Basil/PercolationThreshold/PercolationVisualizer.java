/****************************************************************************
 *  Compilation:  javac PercolationVisualizer.java
 *  Execution:    java PercolationVisualizer input.txt
 *  Dependencies: Percolation.java StdDraw.java In.java
 *
 *  This program takes the name of a file as a command-line argument.
 *  From that file, it
 *
 *    - Reads the grid size N of the percolation system.
 *    - Creates an N-by-N grid of sites (intially all blocked)
 *    - Reads in a sequence of sites (row i, column j) to open.
 *
 *  After each site is opened, it draws full sites in light blue,
 *  open sites (that aren't full) in white, and blocked sites in black,
 *  with with site (1, 1) in the upper left-hand corner.
 *
 ****************************************************************************/
package Basil.PercolationThreshold;
import java.awt.Font;



public class PercolationVisualizer {

    // delay in miliseconds (controls animation speed)
    private static final int DELAY = 100;

    // draw N-by-N percolation system
    public static void draw(Percolation perc, int N) {
        StdDraw.clear();
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setXscale(0, N);
        StdDraw.setYscale(0, N);
        StdDraw.filledSquare(N/2.0, N/2.0, N/2.0);

        // draw N-by-N grid
        int opened = 0;
        for (int row = 1; row <= N; row++) {
            for (int col = 1; col <= N; col++) {
                if (perc.isFull(row, col)) {
                    StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
                    opened++;
                }
                else if (perc.isOpen(row, col)) {
                    StdDraw.setPenColor(StdDraw.WHITE);
                    opened++;
                }
                else
                    StdDraw.setPenColor(StdDraw.BLACK);
                StdDraw.filledSquare(col - 0.5, N - row + 0.5, 0.45);
            }
        }

        // write status text
        StdDraw.setFont(new Font("SansSerif", Font.PLAIN, 12));
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text(.25*N, -N*.025, opened + " open sites");
        if (perc.percolates()) StdDraw.text(.75*N, -N*.025, "percolates");
        else                   StdDraw.text(.75*N, -N*.025, "does not percolate");

    }
    public static void main(String[] args) {
        In in = new In( new java.util.Scanner("10\n" +
                " 10   2\n" +
                "  2  10\n" +
                "  6   8\n" +
                "  2   6\n" +
                "  1   4\n" +
                "  8   4\n" +
                " 10   1\n" +
                "  4   2\n" +
                "  4   8\n" +
                "  9   3\n" +
                "  2   2\n" +
                "  9   1\n" +
                "  4   3\n" +
                "  5   5\n" +
                "  5   7\n" +
                "  2   8\n" +
                "  6   4\n" +
                "  7   5\n" +
                "  9   6\n" +
                "  3   7\n" +
                "  4   7\n" +
                "  7   1\n" +
                "  9   4\n" +
                "  3  10\n" +
                "  1  10\n" +
                " 10  10\n" +
                "  9   7\n" +
                "  1   5\n" +
                "  9   8\n" +
                "  6   1\n" +
                "  2   5\n" +
                "  3   4\n" +
                "  6   9\n" +
                "  5   8\n" +
                "  3   2\n" +
                "  4   6\n" +
                "  1   7\n" +
                "  7   9\n" +
                "  3   9\n" +
                "  4   4\n" +
                "  4  10\n" +
                "  3   5\n" +
                "  3   8\n" +
                "  1   8\n" +
                "  3   1\n" +
                "  6   7\n" +
                "  2   3\n" +
                "  7   4\n" +
                "  9  10\n" +
                "  7   6\n" +
                "  5   2\n" +
                "  8   3\n" +
                " 10   8\n" +
                "  7  10\n" +
                "  4   5\n" +
                "  8  10\n"));      // input file
        int N = in.readInt();         // N-by-N percolation system

        // turn on animation mode
        StdDraw.show(0);

        // repeatedly read in sites to open and draw resulting system
        Percolation perc = new Percolation(N);
        draw(perc, N);
        StdDraw.show(DELAY);
        while (!in.isEmpty()) {
            int i = in.readInt();
            int j = in.readInt();
            perc.open(i, j);
            draw(perc, N);
            StdDraw.show(DELAY);
        }
    }
}
