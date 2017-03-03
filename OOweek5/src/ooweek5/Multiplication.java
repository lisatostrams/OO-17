/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooweek5;

/**
 *
 * @author Lisa Tostrams s4386167
 */
public class Multiplication extends TwoArg{
    private BaseExp exp1;
    private BaseExp exp2; 
    
    public Multiplication(BaseExp e1, BaseExp e2) {
        this.exp1 = e1; 
        this.exp2 = e2; 
    }
    
    @Override
    public String toString() {
        return "(" + exp1.toString() + "*" + exp2.toString() + ")";
    }
    
}
