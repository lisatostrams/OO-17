package opdracht6;

import java.util.Collection;
import java.util.List;


/**
 * An interface for representing nodes in a state space.
 * 
 * @author Sjaak Smetsers
 * @version 1.2
 * @date 28-02-2015
 * 
 * Lisa Tostrams s4386167
 */
public interface Configuration extends Comparable<Configuration> {
    /*
     * To obtain the successors for a specific configuration
     * @return a collection of configurations containing the successors
     */
	public Collection<Configuration> successors ();
    /*
     * For marking final / solution configurations.
     */
	public boolean isSolution ();
        public Configuration getParent(); 
        public default List<Configuration> pathFromRoot(){
            throw new UnsupportedOperationException( "pathFromRoot: not supported yet." ) ;
        }
}