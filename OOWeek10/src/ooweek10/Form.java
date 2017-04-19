/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooweek10;

/**
 *
 * @author Lisa Tostrams s4386167
 */
public interface Form <T>{
    <T> T accept(FormVisitor<T> visitor); 
}
