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

    /**
     * Dit is de constructor van spikkels waar een ijsje aan mee wordt gegeven.
     * @param ijsje 
     */
    public Spikkels(Ijsje ijsje) {
        super(ijsje);
    }

    /**
     * Deze functie returned de oude beschrijving van het ijsje met spikkels er aan toegevoegd.
     * @return 
     */
    @Override
    public String geefBeschrijving() {
        return ijsje.geefBeschrijving() + ", spikkels";
    }
    
    /**
     * Deze functie returned de prijs van het ijsje.
     * @return 
     */
    @Override
    public int prijs (){
        return super.prijs();
    }
    
}
