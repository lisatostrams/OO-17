package qtrees;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author Maurice Swanenberg s4331095
 * @author Lisa Tostrams
 */
public class QTree {
    QTNode root;
    
    /**
     * creates a quadtree based on a string
     * @param input 
     */
    public QTree( Reader input ) {
        root = readQTree( input );
    }
    
    /**
     * creates a quadtree based on a bitmap
     * @param bitmap 
     */
    public QTree( Bitmap bitmap ) {
        root = bitmap2QTree( 0, 0,  bitmap.getWidth(), bitmap );
    }

    /**
     * fills a bitmap
     * @param bitmap 
     */
    public void fillBitmap ( Bitmap bitmap ) {
        root.fillBitmap(0, 0, bitmap.getWidth(), bitmap);
    }

    /**
     * adds a string to a string
     * @param sb 
     */
    public void writeQTree( Writer sb ) {
        root.writeNode( sb );
    }
    
    /**
     * interprets the meaning of the values in the string to the nodes of a quadtree
     * @param input
     * @return 
     */
    private static QTNode readQTree( Reader input )  {
        int r = 0;
        while( r != -1 ) {
           
            try { 
                r = input.read();
            } catch (IOException ex) {
                Logger.getLogger(QTree.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            if(r == '1') {
                GreyNode node = new GreyNode(); 
                
                // roep 4 keer recursief readQTree aan
                // vul de 4 quadranten
                //....
                for(int i =0; i < 4; i++)
                    node.setChild(i, readQTree(input));
                return node; 
            }
            //if(r == -1) break;
            else {
                try {
                    r = input.read();
                } catch (IOException ex) {
                    Logger.getLogger(QTree.class.getName()).log(Level.SEVERE, null, ex);
                }
                if(r == '1') return new WhiteLeaf(); 
                if(r == '0') return new BlackLeaf();
                    
                
            }
        }
        return null;
    }
    
    /**
     * converts the bitmap to a quadtree
     * @param x
     * @param y
     * @param width
     * @param bitmap
     * @return 
     */
    public static QTNode bitmap2QTree( int x, int y, int width, Bitmap bitmap ) {
        if(bitmap.allBlack(x, y, width))
            return new BlackLeaf();
        if(bitmap.allWhite(x, y, width))
            return new WhiteLeaf();
        else{
            GreyNode node = new GreyNode();
            node.setChild(0, bitmap2QTree(x, y, width/2, bitmap));
            node.setChild(1, bitmap2QTree(x+width/2, y, width/2, bitmap));
            node.setChild(2, bitmap2QTree(x+width/2, y+width/2, width/2, bitmap));
            node.setChild(3, bitmap2QTree(x, y+width/2, width/2, bitmap));
            return node;
        }
    }

}
