/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week9ijsjes;

/**
 *
 * @author Maurice Swanenberg s4331095
 * @author Lisa Tostrams s4386167
 */
public abstract class Topping extends Ijsje{

    protected Ijsje ijsje;
    
    public Topping(Ijsje ijsje){
        this.ijsje = ijsje;
    }
    
    @Override
    public int prijs() {
        return ijsje.prijs();
    }
    
    @Override
    public abstract String geefBeschrijving();
    
}
