package opdracht6;

import java.util.LinkedList;

/**
 *
 * @author Pieter Koopman, Sjaak Smetsers
 * 
 * Lisa Tostrams s4386167
 */
public class Opdracht6
{

    public static void main(String[] args) {
       // int [] game = {1,2,3, 4,5,6, 7,9,8};
        int [] game = {1,2,9, 4,6,3, 7,5,8};
       // int [] game = {1,4, 2,3};

        SlidingGame s = new SlidingGame (game, null);
        System.out.println(s);
       
        Solver solver = new Solver(s);
        System.out.println(solver.solve());
    }
}
