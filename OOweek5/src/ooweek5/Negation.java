/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooweek5;

import java.util.Map;

/**
 *
 * @author Lisa Tostrams s4386167
 * @author Maurice Swanenberg s4331095
 */
public class Negation extends OneArg{
    private BaseExp expr; 
    public Negation(BaseExp exp) {
        this.expr = exp; 
    }
    
    @Override
    public double eval(Map<String, Double> map) {
        return -1*expr.eval(map); 
    }
    
    @Override
    public BaseExp pe() {
        if(expr instanceof Constant) {
            Constant e = (Constant) expr; 
            return new Constant(-e.getVal()); 
        }
        return this; 
    }
    
    @Override
    public String toString() {
        return "!" + expr.toString(); 
    }
}
