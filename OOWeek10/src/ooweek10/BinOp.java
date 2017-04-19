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
public enum BinOp {
    AndOp(" /\\ ") {
        public boolean apply(boolean a1, boolean a2) {
            return a1 && a2; 
        }
    },
    OrOp(" \\/ ") {
        public boolean apply(boolean a1, boolean a2) {
            return a1 || a2;
        }
    },
    ImpliesOp(" => ") {
        public boolean apply(boolean a1, boolean a2) {
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

