/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooweek3interfaces;

/**
 *
 * @author Maurice Swanenberg
 * @author Lisa Tostrams
 */
public class Rectangle implements geometricObject{
    Coordinate corner;
    double width;
    double height;
    
    /**
     * Deze constructor maakt een rechthoek aan, waar de coordinaten voor de hoek, de hoogte en de breedte wordt meegegeven.
     * @param x
     * @param y
     * @param width
     * @param height 
     */
    public Rectangle(double x, double y, double width, double height){
        corner = new Coordinate(x,y);
        this.width = width;
        this.height = height;
    }

    /**
     * Deze functie returned de linkerzijde van de rechthoek.
     * @return 
     */
    @Override
    public double getLeftBorder() {
        return corner.getX();
    }
    /**
     * Deze functie returned de rechterzijde van de rechthoek.
     * @return 
     */
    @Override
    public double getRightBorder() {
        return corner.getX()+width;
    }

    /**
     * Deze functie returned de onderzijde van de rechthoek.
     * @return 
     */
    @Override
    public double getBottomBorder() {
        return corner.getY();
    }

    /**
     * Deze functie returned de bovenzijde van de rechthoek.
     * @return 
     */
    @Override
    public double getTopBorder() {
        return corner.getY()+height;
    }

    /**
     * Deze functie returned het gebied van een rechthoek.
     * @return 
     */
    @Override
    public double getArea() {
        return height*width;
    }

    /**
     * Deze functie verplaatst een rechthoek, door middel van de hoek te verplaatsen en de hoogte en breedte gelijk te laten.
     * @param dx
     * @param dy 
     */
    @Override
    public void moveObject(double dx, double dy) {
        corner.setX(dx);
        corner.setY(dy);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("This rectangle has got a left lower corner ").append(corner.toString()).append(" a heigth of ").append(height).append(", and a width of ").append(width).append(".");
        return sb.toString();
    }

   

}
