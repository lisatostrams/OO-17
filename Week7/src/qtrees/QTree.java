package qtrees;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class QTree {
    QTNode root;
    
    public QTree( Reader input ) {
        root = readQTree( input );
    }
    
    public QTree( Bitmap bitmap ) {
        root = bitmap2QTree( 0, 0,  bitmap.getWidth(), bitmap );
    }

    public void fillBitmap ( Bitmap bitmap ) {
        root.fillBitmap(0, 0, bitmap.getWidth(), bitmap);
    }

    public void writeQTree( Writer sb ) {
        root.writeNode( sb );
    }
    
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
    
    public static QTNode bitmap2QTree( int x, int y, int width, Bitmap bitmap ) {
        if(bitmap.allBlack(x, y, width))
            return new BlackLeaf();
        if(bitmap.allWhite(x, y, width))
            return new WhiteLeaf();
        else{
            return new GreyNode(x, y, width, bitmap);
        }
    }

}
