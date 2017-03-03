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
public class Variable extends NoArg {
    private String name; 
    
    public Variable(String n) {
        this.name = n; 
    }
    
   public String toString() {
       return name; 
   }
}
