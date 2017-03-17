
package qtrees;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/**
 *
 * @author Sjaak Smetsers
 * @author Maurice Swanenberg s4331095
 * @author Lisa Tostrams s4386167
 * @version 11-03-2016
 */
public interface QTNode {
    public void fillBitmap( int x, int y, int width, Bitmap bitmap );
    public void writeNode( Writer out );
    
    
}
