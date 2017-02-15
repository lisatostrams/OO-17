/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooweek3interfaces;

/**
 *
 * @author mauri
 */
public class Circle implements geometricObject{
    Coordinate center;
    double radius;
    
    public Circle(double x, double y, double r){
        center = new Coordinate(x,y);
        radius = r;
    }

    @Override
    public double getLeftBorder() {
        return center.getX()-radius;
    }

    @Override
    public double getRightBorder() {
        return center.getX()+radius;
    }

    @Override
    public double getBottomBorder() {
        return center.getY()-radius;
    }

    @Override
    public double getTopBorder() {
        return center.getY()+radius;
    }

    @Override
    public double getArea() {
        return radius*radius*Math.PI;
    }

    @Override
    public void moveObject(double dx, double dy) {
        center.setX(dx);
        center.setY(dy);
    }

    @Override
    public double compareTo(geometricObject obj) {
        return 0; 
    }
    
}
