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
public class GreyNode implements QTNode{
    
    private QTNode[] children;
    
    public GreyNode(){
        children = new QTNode[4];
    }

    @Override
    public void fillBitmap(int x, int y, int width, Bitmap bitmap) {
        children[0].fillBitmap(x, y, width/2, bitmap);
        children[1].fillBitmap(x+width/2, y, width/2, bitmap);
        children[2].fillBitmap(x+width/2, y+width/2, width/2, bitmap);
        children[3].fillBitmap(x, y+width/2, width/2, bitmap);
    }

    @Override
    public void writeNode(Writer out) {
        try {
            out.write("0");
        } catch (IOException ex) {
            Logger.getLogger(GreyNode.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
