/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooweek3interfaces;

/**
 *
 * @author Maurice Swanenberg s4331095
 * @author Lisa Tostrams s4386167
 */
public class Coordinate {
    double x;
    double y;
    /**
     * Deze constructor maakt een coorinaat aan met een gegeven x-coordinaat en een gegeven y-coordinaat.
     * @param x
     * @param y 
     */
    public Coordinate(double x, double y){
        this.x = x;
        this.y = y;
    }
    
    public double getX(){
        return x;
    }
    
    public double getY(){
        return y;
    }
    
    public void setX(double x){
        this.x = x;
    }
    
    public void setY(double y){
        this.y = y;
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("with x-coordinate ").append(x).append(" and y-coordinate ").append(y).append(",");
        return sb.toString();
    }
}
