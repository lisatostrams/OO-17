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
public interface geometricObject {
    double getLeftBorder();
    double getRightBorder();
    double getBottomBorder();
    double getTopBorder();
    double getArea();
    void moveObject(double dx, double dy);
    int compareTo(geometricObject o);
}
