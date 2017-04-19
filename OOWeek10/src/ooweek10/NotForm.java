/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooweek10;

/**
 *
 * @author Lisa Tostrams s4386167
 */
public class NotForm<T> implements Form{
    private Form operand;
    
    /**
     * negate operand op
     * @param op 
     */
    public NotForm(Form op) {
        this.operand = op;
    }
    
    public Form get(){
        return operand;
    }
  
    
    /**
     *
     * @param v
     * @return 
     */
    @Override
    public T accept(FormVisitor v) {
        return (T) v.visit(this);
    }
       
    @Override
    public String toString() {
        return " ~" + operand; 
    }
}
