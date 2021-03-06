/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooweek10;

/**
 * @author Maurice Swanenberg s4331095
 * @author Lisa Tostrams s4386167
 */
public class StringForm<R> implements Form {
    private String atom;
    
    /**
     * assign atom name
     * @param atom 
     */
    public StringForm(String atom) {
        this.atom = atom; 
    }

    @Override
    public R accept(FormVisitor visitor) { 
        return (R) visitor.visit(this);
    }
    
    @Override
    public String toString() {
        return atom; 
    }  
}
