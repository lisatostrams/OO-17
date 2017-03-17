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
 * Multiplication class
 */
public class Multiplication extends TwoArg{

    public Multiplication(BaseExp e1, BaseExp e2) {
        super(e1, e2);  
    }
    
    /**
     * evaluate with map
     * @param map
     * @return 
     */
    @Override
    public double eval(Map<String, Double> map) {
        return getX().eval(map) * getY().eval(map);
    }
    
    /**
     * optimise multiplication, const*const = const; 0*expr = 0; recursively optimise
     * @return 
     */
    @Override
    public BaseExp pe() {
        if(getX() instanceof Constant && getY() instanceof Constant) {
            Constant e1 = (Constant) getX();
            Constant e2 = (Constant) getY(); 
            return new Constant(e1.getVal()* e2.getVal()); 
        }
        
        if(getX() instanceof Constant) {
            Constant x = (Constant) getX();
            if(x.getVal() == 0)
                return x; 
            else {
                BaseExp y = getY().pe();
                return new Add(getX(), y); 
            }   
        } 
        
        if(getY() instanceof Constant) {
            Constant y = (Constant) getY();
            if(y.getVal() == 0)
                return y; 
            else {
                BaseExp x = getX().pe();
                return new Add(x, getY()); 
            }   
        }
        
        BaseExp exp1 = getX().pe(); 
        BaseExp exp2 = getY().pe(); 
        return new Multiplication(exp1, exp2); 
    }
    
    @Override
    public String toString() {
        return "(" + getX().toString() + "*" + getY().toString() + ")";
    }
    
}
