/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooweek10;

/**
 *
 * @author Lisa Tostrams s4386167
 * Binary operators AND, OR, and IMPLICATION
 */
public class BinOpForm <R> implements Form {
    private BinOp op;
    private Form leftOperand;
    private Form rightOperand;
    
    /**
     * assign operator, left and right hand values
     * @param op
     * @param left
     * @param right 
     */
    public BinOpForm(BinOp op, Form left, Form right) {
        this.op = op;
        this.leftOperand = left;
        this.rightOperand = right;
    }
    
    /**
     * 
     * @return left hand 
     */
     public Form getLeft(){
        return leftOperand;
    }
    
     /**
      * 
      * @return right hand 
      */
    public Form getRight() {
        return rightOperand; 
    }
    
    /**
     * 
     * @return operator 
     */
    public BinOp getOp() {
        return op; 
    }
    
   
    
    @Override
    public R accept(FormVisitor v) { // void maken !!!
        return (R) v.visit(this); 
    
    }
    
}
