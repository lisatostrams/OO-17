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
public class Circle implements geometricObject{
    Coordinate center;
    double radius;
    
    /**
     * Deze constructor maakt een cirkel, waar de coordinaten van het centrum en de straal wordt meegegeven.
     * @param x
     * @param y
     * @param r 
     */
    public Circle(double x, double y, double r){
        center = new Coordinate(x,y);
        radius = r;
    }

    /**
     * Deze functie returned de linkerzijde van de kleinst mogelijk rechthoek die om de cirkel heen te maken is.
     * @return 
     */
    @Override
    public double getLeftBorder() {
        return center.getX()-radius;
    }

    /**
     * Deze functie returned de rechterzijde van de kleinst mogelijk rechthoek die om de cirkel heen te maken is.
     * @return 
     */
    @Override
    public double getRightBorder() {
        return center.getX()+radius;
    }

    /**
     * Deze functie returned de onderzijde van de kleinst mogelijk rechthoek die om de cirkel heen te maken is.
     * @return 
     */
    @Override
    public double getBottomBorder() {
        return center.getY()-radius;
    }

    /**
     * Deze functie returned de bovenzijde van de kleinst mogelijk rechthoek die om de cirkel heen te maken is.
     * @return 
     */
    @Override
    public double getTopBorder() {
        return center.getY()+radius;
    }

    /**
     * Deze functie returned het gebied van de cirkel.
     * @return 
     */
    @Override
    public double getArea() {
        return radius*radius*Math.PI;
    }

    /**
     * Deze functie verplaatst een cirkel, door het centrum te verplaatsen en de straal gelijk te laten.
     * @param dx
     * @param dy 
     */
    @Override
    public void moveObject(double dx, double dy) {
        center.setX(dx);
        center.setY(dy);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("This circle has got a center ").append(center.toString()).append(" and a radius of ").append(radius).append(".");
        return sb.toString();
    }
}
