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
public class Rectangle implements geometricObject,Comparable<geometricObject>{
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

    @Override
    public int compareTo(geometricObject o) {
        if(this.getArea() < o.getArea())
            return -1;
        if(this.getArea() > o.getArea())
            return 1;
        return 0;
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("This rectangle has got a left lower corner ").append(corner.toString()).append(" a heigth of ").append(height).append(", and a width of ").append(width).append(".");
        return sb.toString();
    }

}
