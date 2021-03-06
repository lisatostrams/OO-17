import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Pieter Koopman, Sjaak Smetsers
 * @author Maurice Swanenberg s4331095
 * @version 1.3
 * @date 07-03-2016
 * A template implementation of a sliding game 
 * implementing the Graph interface
 */
public class SlidingGame implements Configuration {

    public static final int N = 3, SIZE = N * N, HOLE = SIZE;
    /**
     * The board is represented by a 2-dimensional array; the position of the
     * hole is kept in 2 variables holeX and holeY
     */
    private int[][] board;
    private int holeX, holeY;
    private Direction[] directions = {Direction.NORTH,Direction.EAST,Direction.SOUTH,Direction.WEST};

    /**
     * A constructor that initializes the board with the specified array
     *
     * @param start: a one dimensional array containing the initial board. The
     * elements of start are stored row-wise.
     */
    public SlidingGame(int[] start) {
        board = new int[N][N];

        assert start.length == N * N : "Length of specified board incorrect";

        for (int p = 0; p < start.length; p++) {
            board[p % N][p / N] = start[p];
            if (start[p] == HOLE) {
                holeX = p % N;
                holeY = p / N;
            }
        }
    }
    
    private boolean LegalMove(Direction d){
        switch(d){
            case NORTH:
                return d.GetDY()+holeY >=0;
            case EAST:
                return d.GetDX()+holeX <=N;
            case SOUTH:
                return d.GetDY()+holeY <=N;
            case WEST:
                return d.GetDX()+holeX >=0;
            default: return false;
        }
    }

    /**
     * Converts a board into a printable representation. The hole is displayed
     * as a space
     *
     * @return the string representation
     */
    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder();
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                int puzzel = board[col][row];
                buf.append(puzzel == HOLE ? "  " : puzzel + " ");
            }
            buf.append("\n");
        }
        return buf.toString();
    }

    // Hier nog even eventueel opnieuw naar kijken.
    @Override
    public boolean equals(Object o) {
        if(o == null || o.getClass() != getClass())
            return false;
        else{
            SlidingGame new_puzzel = (SlidingGame) o;
            for(int row = 0; row < N; row++){
                for(int col = 0; col < N; col++){
                    if(board[col][row] != new_puzzel.board[col][row])
                        return false;
                }
            }
            return true;
        }
    }

    @Override
    public boolean isSolution() {
        for(int i = 0; i < SIZE; i++){
            if(board[i%N][i/N]!=i+1)
                return false;
        }
        return true;
    }

    @Override
    public Collection<Configuration> successors() {
        List succ = new LinkedList<SlidingGame>();
        for(Direction d : directions){
            if(LegalMove(d)){
                int[][] newBoard = new int[N][N];
                for(int i = 0; i < N; i++){
                    for( int j = 0; j < N; j++){
                        newBoard[i][j] = board[i][j];
                    }
                }
                newBoard[holeX][holeY] = newBoard[holeX+d.GetDX()][holeY+d.GetDY()];
                newBoard[holeX+d.GetDX()][holeY+d.GetDY()]= HOLE;
            }
        }
        return succ;
    }

    @Override
    public int compareTo(Configuration g) {
        throw new UnsupportedOperationException("compareTo : not supported yet.");
    }

    @Override
    public Configuration parent() {
        throw new UnsupportedOperationException("parent: Not supported yet.");
    }

}
