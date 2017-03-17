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
 * Negation class
 */
public class Negation extends OneArg{
 
    public Negation(BaseExp exp) {
        super(exp);  
    }
    
    @Override
    public double eval(Map<String, Double> map) {
        return -1*getExp().eval(map); 
    }
    
    /**
     * neg(const) = -const
     * @return 
     */
    @Override
    public BaseExp pe() {
        if(getExp() instanceof Constant) {
            Constant e = (Constant) getExp(); 
            return new Constant(-e.getVal()); 
        }
        return this; 
    }
    
    @Override
    public String toString() {
        return "-" + getExp().toString(); 
    }
}
