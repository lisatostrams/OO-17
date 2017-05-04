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
public class FalseForm<R> implements Form{

    @Override
    public R accept(FormVisitor visitor) { 
        return (R) visitor.visit(this);
    }
    
    @Override
    public String toString() {
        return "false"; 
    }
    
}
