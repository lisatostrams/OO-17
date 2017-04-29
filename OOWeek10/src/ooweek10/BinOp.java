/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooweek10;

import java.util.function.BinaryOperator;

/**
 * @author Maurice Swanenberg s4331095
 * @author Lisa Tostrams s4386167
 */
public enum BinOp implements BinaryOperator<Boolean>{
    AndOp(" /\\ ") {
        @Override
        public Boolean apply(Boolean a1, Boolean a2) {
            return a1 && a2; 
        }
    },
    OrOp(" \\/ ") {
        @Override
        public Boolean apply(Boolean a1, Boolean a2) {
            return a1 || a2;
        }
    },
    ImpliesOp(" => ") {
        @Override
        public Boolean apply(Boolean a1, Boolean a2) {
            return !a1 || a2;
        }
    };
    
    private String string; 
    
    private BinOp(String string){
        this.string = string; 
    }
    
    @Override
    public String toString() {
        return this.string;
    }
}

