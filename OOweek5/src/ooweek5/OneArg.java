/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooweek5;

/**
 *
 * @author Lisa Tostrams s4386167
 * @author Maurice Swanenberg s4331095
 * abstract class for expressions with one arg
 */
public abstract class OneArg extends BaseExp {
        private BaseExp expr;
        /**
         * constructor
         * @param exp 
         */
        public OneArg(BaseExp exp) {
            this.expr = exp; 
        }
        
        public BaseExp getExp() {
            return expr; 
        }
}
