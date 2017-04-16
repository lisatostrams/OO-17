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
public class Chocodip extends Topping{

    /**
     * Dit is de constructor van chocodip waar een ijsje aan mee wordt gegeven.
     * @param ijsje 
     */
    public Chocodip(Ijsje ijsje) {
        super(ijsje);
    }

    /**
     * Deze functie returned de oude beschrijving van het ijsje met chocodip er aan toegevoegd.
     * @return 
     */
    @Override
    public String geefBeschrijving() {
        return ijsje.geefBeschrijving() + ", chocodip";
    }
    
    /**
     * Deze functie returned de oude prijs van het ijsje plus de 30 cent voor de chocodip.
     * @return 
     */
    @Override
    public int prijs(){
        return super.prijs() + 30;
    }
    
}
