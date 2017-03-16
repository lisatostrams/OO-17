/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qtrees;

import java.io.IOException;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mauri
 */
public class WhiteLeaf implements QTNode{

    @Override
    public void fillBitmap(int x, int y, int width, Bitmap bitmap) {
        for(int i = 0; i < width; i++){
            for(int j = 0; j < width; j++){
                bitmap.setBit(x+i, y+1, true);
            }
        }
    }

    @Override
    public void writeNode(Writer out) {
        try {
            out.write("01");
        } catch (IOException ex) {
            Logger.getLogger(WhiteLeaf.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
