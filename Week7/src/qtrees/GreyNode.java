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
 * @author Lisa Tostrams
 */
public class GreyNode implements QTNode{
    
    private QTNode[] children;
    
    /**
     * constructor of GreyNode, which initializes the array
     */
    public GreyNode(){
        children = new QTNode[4];
    }

    /**
     * fills a bitmap for each of the quadrants/children.
     * @param x
     * @param y
     * @param width
     * @param bitmap 
     */
    @Override
    public void fillBitmap(int x, int y, int width, Bitmap bitmap) {
        children[0].fillBitmap(x, y, width/2, bitmap);
        children[1].fillBitmap(x+width/2, y, width/2, bitmap);
        children[2].fillBitmap(x+width/2, y+width/2, width/2, bitmap);
        children[3].fillBitmap(x, y+width/2, width/2, bitmap);
    }

    /**
     * sets a child to a given child
     * @param child
     * @param child_node 
     */
    public void setChild(int child, QTNode child_node) {
        children[child] = child_node; 
    }
   
    /**
     * adds 1 to the string
     * @param out 
     */
    @Override
    public void writeNode(Writer out) {
        try {
            out.write("1");
            for(int i = 0; i < 4; i++) 
                children[i].writeNode(out);
        } catch (IOException ex) {
            Logger.getLogger(GreyNode.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
