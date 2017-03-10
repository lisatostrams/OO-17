package opdracht6;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Vector;


/**
 * A class that implements a breadth-first search algorithm
 * for finding the Configurations for which the isSolution predicate holds
 * @author Pieter Koopman, Sjaak Smetsers
 * @version 1.3
 * @date 28-02-2013
 * 
 * Lisa Tostrams s4386167
 * @author Maurice Swanenberg s4331095
 */ 
public class Solver
{
    // A queue for maintaining graphs that are not visited yet.
    Queue<Configuration> toExamine;
    Collection<Configuration> examined;

    public Solver(Configuration g) {
        toExamine = new PriorityQueue<>(); 
        toExamine.add(g); 
        examined = new HashSet<>();       
    }
    
    /* A skeleton implementation of the solver
     * @return a string representation of the solution
     */
    public String solve () {        
        int current = 0;
        while (! toExamine.isEmpty() ) {
            Configuration next = toExamine.remove();
            examined.add(next);
            if ( next.isSolution() ) {
                List<Configuration> path = next.pathFromRoot();
                String str = "Path: \n";
                int c = 0;
                while(!path.isEmpty()) {
                    str += (c++ + ": \n" + path.remove(path.size()-1) + "\n");
                }
                return str;
            } else {
                
                for ( Configuration succ: next.successors() ) {
                    if(!examined.contains(succ)) {
                        toExamine.add  (succ);
                    }
                }
            }
            current ++;
        }
        return "Failure! No solution found.";
    }
    
}
