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
 */
public abstract class NoArg extends BaseExp{
    
    /**
     * const and vars cannot be further optimalised
     * @return 
     */
    @Override
    public BaseExp pe() {
        return this; 
    }
}
