/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week12.mandelmodel;

/**
 * Klasse die een coordinaat van een pixel weergeeft.
 * @author Lisa Tostrams
 * @author Maurice Swanenberg - s4331095
 */
public class Point {
    double x, y;  // x en y coordinaat
    
    /**
     * Constructor
     * @param a
     * @param b 
     */
    public Point(double a, double b) {
        x = a;
        y = b;
    }
    
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
}
