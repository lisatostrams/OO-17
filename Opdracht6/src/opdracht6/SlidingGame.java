package opdracht6;

import java.util.*;

/**
 * @author Pieter Koopman, Sjaak Smetsers
 * @version 1.2
 * @date 28-02-2015
 * A template implementation of a sliding game also
 * implementing the Graph interface
 * 
 * Lisa Tostrams s4386167
 * @author Maurice Swanenberg s4331095
 * bla
 */
public class SlidingGame implements Configuration
{
    public static final int N = 3, SIZE = N * N, HOLE = SIZE;
    /*
     * The board is represented by a 2-dimensional array;
     * the position of the hole is kept in 2 variables holeX and holeY
     */
    
    
    private SlidingGame parent; 
    private int [][] board;
    private int holeX, holeY;
    
    /*
     * A constructor that initializes the board with the specified array
     * @param start: a one dimensional array containing the initial board.
     * The elements of start are stored row-wise.
     */
    public SlidingGame (int [] start, SlidingGame prt) {
        board = new int[N][N];
        this.parent = prt; 
        assert start.length == N*N: "Length of specified board incorrect";
        
        for( int p = 0; p < start.length; p++) {
            board[p % N][p / N] = start[p];
            if ( start[p] == HOLE ) {
                holeX = p % N;
                holeY = p / N;
            }
        }
   }    

    /*
     * Converts a board into a printable representation.
     * The hole is displayed as a space
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
     
    /*
     * a standard implementation of equals checking
     * whether 2 boards are filled in exactly the same way
     * @return a boolean indicating equality
     */
   @Override
    public boolean equals(Object o) {
        if (o == null || o.getClass() != getClass()) {
            return false;
        } else {
            SlidingGame other_puzzle = (SlidingGame) o;
            for (int row = 0; row < N; row++) {
                for (int col = 0; col < N; col++) {
                    if (board[col][row] != other_puzzle.board[col][row]) {
                        return false;
                    }
                }
            }
            return true;
        }
 	}

    /**
     * hashcode berekenen met formule uit opdracht
     * @return hashwaarde
     */
    @Override
    public int hashCode() {
        int sum = 0;
        for(int i = 0; i < N-1; i++) {
            for(int j = 0; j < N-1; j++) {
                sum += (board[i][j]*(31^(i+j*N)));
            }
        }
       // System.out.println(sum); 
        return sum;
    }
    
    /**
     * check of de puzzel af is
     * @return true als opvolgende nummers kloppen
     */
    @Override
    public boolean isSolution () {
        int check = 1; 
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(board[j][i] != check) return false; 
                check++; 
            }
        }
        return true; 
    }

    /**
     * check welke kanten je opkan
     * @return collection van mogelijke puzzels
     */
    @Override
    public Collection<Configuration> successors () {
       LinkedList opvolgers = new LinkedList();
       if(go_north()) opvolgers.add(next_game(Direction.NORTH));
       if(go_south()) opvolgers.add(next_game(Direction.SOUTH));
       if(go_west())  opvolgers.add(next_game(Direction.WEST));
       if(go_east())  opvolgers.add(next_game(Direction.EAST));
       return opvolgers; 
    }

    /**
     * check north
     * @return true als north een mogelijkheid is (idem voor de andere functies)
     */
    boolean go_north() {
        return (holeY > 0); 
    }
    
    boolean go_south() {
        return (holeY < N-1); 
    }
    
    boolean go_west() {
        return (holeX >0);
    }
    
    boolean go_east() {
        return (holeX < N-1); 
    }
    @Override
    public List<Configuration> pathFromRoot() {
        List<Configuration> path = new ArrayList<>(); 
        path.add(this); 
        Configuration p = this.parent;
        while(p != null) {
            path.add(p.getParent());
            p = p.getParent(); 
        }
        return path; 
    }
    
    /** creeert volgende puzzel als je een stap in direction dir neemt
     * @param dir
     * @return 
     */
    SlidingGame next_game(Direction dir) {
        int[][] copyboard = new int[N][N];
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                copyboard[col][row] = board[col][row];
            }
        }
        int copyX = holeX;
        int copyY = holeY; 
        int newx = copyX + dir.GetDX();
        int newy = copyY + dir.GetDY();

        int t = copyboard[newx][newy];
        copyboard[newx][newy] = HOLE; 
        copyboard[copyX][copyY] = t;

        int newgame [] = new int[SIZE]; 
        int n = 0;
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                newgame[n] = copyboard[col][row];
                n++;
            }
        }
        SlidingGame g = new SlidingGame(newgame, this);
        return g; 
    }
    @Override
    public SlidingGame getParent() {
        return parent; 
    }
    /**
     * vergelijkt twee puzzels this en g volgens manhattandistance
     * @param g
     * @return 
     */
    @Override
    public int compareTo(Configuration g) {
        int current = manhattanDistance(this);
        int comp = manhattanDistance(g);
        return current-comp;
     }
    
    /**
     * berekent manhattandistance van alle puzzelstukjes in game
     * @param game
     * @return distance
     */
    int manhattanDistance(Configuration game) {
        int n = 1;
        int distance = 0;
        for(int row = 0; row < N; row++) {
            for(int col = 0; col < N; col++) {
                distance += (Math.abs((board[row][col] - n))%N)+1;
                n++; 
            }
        }
        //System.out.println(distance); 
        return distance;
    }
}
