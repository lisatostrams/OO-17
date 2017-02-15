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
public class Circle implements geometricObject,Comparable<geometricObject>{
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
        sb.append("This circle has got a center ").append(center.toString()).append(" and a radius of ").append(radius).append(".");
        return sb.toString();
    }
}
