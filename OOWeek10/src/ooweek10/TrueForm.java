/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooweek10;

/**
 *
 * @author Lisa Tostrams s4386167
 * @param <T>
 */
public class TrueForm<T> implements Form{

    @Override
    public T accept(FormVisitor visitor) {
        return (T) visitor.visit(this);
    }
    
    @Override
    public String toString() {
        return "true"; 
    }
    
    
}
