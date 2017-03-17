/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooweek5;

/**
 *
 * @author Lisa Tostrams s4386167
 * @author Maurice Swanenberg s4331095
 * abstract class for expressions with two args
 */
public abstract class TwoArg extends BaseExp {
    private BaseExp x,y;
    /**
     * constructor
     * @param x
     * @param y 
     */
    public TwoArg(BaseExp x, BaseExp y) {
        this.x = x;
        this.y = y; 
    }
    public BaseExp getX() {
        return x; 
    }
    
    public BaseExp getY() {
        return y; 
    }
}
