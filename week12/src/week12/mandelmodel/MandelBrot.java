/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week12.mandelmodel;

/**
 *
 * @author Lisa Tostrams s4386167
 * @author Maurice Swanenberg - s4331095
 */
public class MandelBrot {
    private final double a, b;
    /**
     * Constructor
     * @param a
     * @param b 
     */
    public MandelBrot(double a, double b) {
        this.a = a;
        this.b = b;
    }
    /**
     * Computes the "mandelgetal" for a point
     * @return 
     */
    public int mandelGetal() {
        int mandel = 0;
        double x = a, y = b;
        for(int i = 0; i < 100; i++) {
            if(Math.sqrt(x*x + y*y) >= 2)
                return mandel;
            else {
                double newX = x * x - y * y + a;
                y = 2 * x * y + b;
                x = newX;
                mandel++;
            }
        }
        if(mandel > 99 && !(Math.sqrt(x*x + y*y) >= 2))
            return Integer.MAX_VALUE;
        else return mandel;  
    }
    
}
