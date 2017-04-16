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
    
    /**
     * Dit is de constructor van Topping waar een ijsje aan mee wordt gegeven.
     * @param ijsje 
     */
    public Topping(Ijsje ijsje){
        this.ijsje = ijsje;
    }
    
    /**
     * Deze funtie returned de prijs van het desbetreffende ijsje.
     * @return 
     */
    @Override
    public int prijs() {
        return ijsje.prijs();
    }
    
    /**
     * Dit is een abstracte methode die de beschrijving van een ijsje returned.
     * @return 
     */
    @Override
    public abstract String geefBeschrijving();
    
}
