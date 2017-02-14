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
public class Rectangle implements geometricObject{
    Coordinate corner;
    double width;
    double height;
    
    public Rectangle(double x, double y, double width, double height){
        corner = new Coordinate(x,y);
        this.width = width;
        this.height = height;
    }

    @Override
    public double getLeftBorder() {
        return corner.getX();
    }

    @Override
    public double getRightBorder() {
        return corner.getX()+width;
    }

    @Override
    public double getBottomBorder() {
        return corner.getY();
    }

    @Override
    public double getTopBorder() {
        return corner.getY()+height;
    }

    @Override
    public double getArea() {
        return height*width;
    }

    @Override
    public void moveObject(double dx, double dy) {
        corner.setX(dx);
        corner.setY(dy);
    }

}
