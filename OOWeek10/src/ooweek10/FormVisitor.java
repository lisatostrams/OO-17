/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooweek10;

/**
 * @author Maurice Swanenberg s4331095
 * @author Lisa Tostrams s4386167
 * @param <R>
 */
public interface FormVisitor<R> {
    R visit(BinOpForm form); 
    R visit(NotForm form);
    R visit(Form form); 
    R visit(TrueForm form);
    R visit(FalseForm form);
    R visit(StringForm form);
}
