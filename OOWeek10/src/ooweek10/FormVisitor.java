/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooweek10;

/**
 *
 * @author Lisa Tostrams s4386167
 * @param <T>
 */
public interface FormVisitor<T> {
    T visit(BinOpForm form); 
    T visit(NotForm form);
    T visit(Form form); 
    T visit(TrueForm form);
    T visit(FalseForm form);
    T visit(StringForm form);
}
