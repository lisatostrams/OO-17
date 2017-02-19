/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooweek3interfaces;

import java.util.Comparator;

/**
 *
 * @author Maurice Swanenberg
 * @author Lisa Tostrams
 */
public interface geometricObject extends Comparable {
    double getLeftBorder();
    double getRightBorder();
    double getBottomBorder();
    double getTopBorder();
    double getArea();
    void moveObject(double dx, double dy);
    @Override
    default int compareTo(Object o) {
        if (o == null && this == null) return 0;
        if (o == null) return 1;
        if (this == null) return -1; 
        geometricObject g = (geometricObject) o; 
        if(this.getArea() < g.getArea())
            return -1;
        if(this.getArea() > g.getArea())
            return 1;
        return 0;
    }
    
   /**
    * 
    */ 
    public static Comparator<geometricObject> ShapeXcomperator = new Comparator<geometricObject>() {
        @Override
        public int compare(geometricObject o1, geometricObject o2) {
            if(o1.getLeftBorder() < o2.getLeftBorder())
                return -1;
            if(o2.getLeftBorder() > o1.getLeftBorder())
                return 1;
            return 0;
        }
    };
    
    /**
     * 
     */
    public static Comparator<geometricObject> ShapeYcomperator = new Comparator<geometricObject>() {
        @Override
        public int compare(geometricObject o1, geometricObject o2) {
            if(o1.getBottomBorder() < o2.getBottomBorder())
                return -1;
            if(o2.getBottomBorder() > o1.getBottomBorder())
                return 1;
            return 0;
        }
    };
}
