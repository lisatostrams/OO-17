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
 */
public class Constant extends NoArg {
    private double value; 
    
    public Constant(double val) {
        this.value = val; 
    }
    
    @Override
    public double eval(Map<String, Double> map) {
        return value; 
    }
    
    public double getVal() {
        return value; 
    }
    
    @Override
    public String toString() {
        return String.valueOf(value); 
    }
}
