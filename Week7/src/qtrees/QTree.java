package qtrees;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class QTree {
    QTNode root;
    
    public QTree( Reader input ) throws IOException {
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
    
    private static QTNode readQTree( Reader input ) throws IOException {
        int r = 0;
        while( r != -1 ) {
            r = input.read(); 
            
            if(r == '1') {
                GreyNode node = new GreyNode(); 
                
                // roep 4 keer recursief readQTree aan
                // vul de 4 quadranten
                //....
                for(int i =0; i < 4; i++)
                    node.setChild(i, readQTree(input));
            }
            if(r == -1) break;
            else {
                r = input.read();
                if(r == 1) return new WhiteLeaf(); 
                else return new BlackLeaf();
                    
                
            }
        }
        return null;
    }
    
    public static QTNode bitmap2QTree( int x, int y, int width, Bitmap bitmap ) {
        return null;
    }

}
