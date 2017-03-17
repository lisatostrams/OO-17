/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooweek5;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Lisa Tostrams s4386167
 * @author Maurice Swanenberg s4331095
 * 
 * Test class 
 */
public class Main {
    public Main() {
        testExpression(); 
    }
    
    /**
     * test expression evaluations and optimisations
     */
    private void testExpression() {
        Map<String, Double> store = new HashMap<>(); 
        store.put("x", 2.);
        store.put("y", 3.);
        store.put("z", 5.); 
        
        BaseExp e1 = add(add(multiply(con(2), con(3)), neg(var("x"))), con(4)); 
        BaseExp e3 = multiply(con(2), con(3)); 
        System.out.println(e1); 
        System.out.println(e1.pe());
        System.out.println(e1.eval(store)); 
      
        BaseExp e2 = neg(var("x")); 
        System.out.println(e2.eval(store));
        
        BaseExp feedback = multiply(con(0), var("x")); //in regards to feedback: this now works fine 
        System.out.println(feedback);
        System.out.println(feedback.pe()); 
    }
    
    /**
     * I got all these from the slides 
     */
    public static Add add(BaseExp x, BaseExp y) {
        return new Add(x, y); 
    }
    
    public static Multiplication multiply(BaseExp x, BaseExp y) {
        return new Multiplication(x, y); 
    }
    
    public static Negation neg(BaseExp x) {
        return new Negation(x); 
    } 
    
    public static Constant con(double x) {
        return new Constant(x); 
    }
    
    public static Variable var(String x) {
        return new Variable(x); 
    } 
}
