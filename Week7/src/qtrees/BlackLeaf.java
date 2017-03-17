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
 * @author Maurice Swanenberg s4331095
 * @author Lisa Tostrams s4386167
 */
public class BlackLeaf implements QTNode{

    /**
     * fills a bitmap with black/false bits
     * @param x
     * @param y
     * @param width
     * @param bitmap 
     */
    @Override
    public void fillBitmap(int x, int y, int width, Bitmap bitmap) {
        for(int i = 0; i < width; i++){
            for(int j = 0; j < width; j++){
                bitmap.setBit(x+i, y+j, false);
            }
        }
    }

    /**
     * adds 00 to the string, the first 0 for a leaf and the latter 0 because its black
     * @param out 
     */
    @Override
    public void writeNode(Writer out) {
        try {
            out.write("00");
        } catch (IOException ex) {
            Logger.getLogger(BlackLeaf.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
