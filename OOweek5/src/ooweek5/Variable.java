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
public class Variable extends NoArg {
    private String name; 
    
    public Variable(String n) {
        this.name = n; 
    }
    
    @Override
    public double eval(Map<String, Double> map) {
        return map.get(name); 
    }
    
    @Override
    public String toString() {
       return name; 
   }
}
