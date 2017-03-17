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
 * Abstract class for expressions
 */
public abstract class BaseExp {
    @Override
    public abstract String toString();  
    public abstract double eval(Map<String, Double> map); 
    public abstract BaseExp pe(); 
}
