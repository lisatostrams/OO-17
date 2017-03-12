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


public class Add extends TwoArg{
    private BaseExp exp1;
    private BaseExp exp2; 
    
    public Add(BaseExp e1, BaseExp e2) {
        this.exp1 = e1; 
        this.exp2 = e2; 
    }
    
    @Override
    public double eval(Map<String, Double> map) {
        return exp1.eval(map) + exp2.eval(map);
    }
    
     @Override
    public BaseExp pe() {
         
        if(exp1 instanceof Constant && exp2 instanceof Constant) {
            Constant e1 = (Constant) exp1;
            Constant e2 = (Constant) exp2; 
            return new Constant(e1.getVal()+ e2.getVal()); 
        }
        exp1 = exp1.pe(); 
        exp2 = exp2.pe(); 
        return this; 
        
        
    }
    
    @Override
    public String toString() {
        return "(" + exp1.toString() + " + " + exp2.toString() + ")"; 
    }
}
