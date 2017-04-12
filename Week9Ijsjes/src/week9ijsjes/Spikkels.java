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
public class Spikkels extends Topping{

    public Spikkels(Ijsje ijsje) {
        super(ijsje);
    }

    @Override
    public String geefBeschrijving() {
        return ijsje.geefBeschrijving() + ", spikkels";
    }
    
    @Override
    public int prijs (){
        return super.prijs();
    }
    
}
