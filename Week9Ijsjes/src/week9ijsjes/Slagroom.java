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
public class Slagroom extends Topping{

    /**
     * Dit is de constructor van slagroom waar een ijsje aan mee wordt gegeven.
     * @param ijsje 
     */
    public Slagroom(Ijsje ijsje) {
        super(ijsje);
    }

    /**
     * Deze functie returned de oude beschrijving van het ijsje met slagroom er aan toegevoegd.
     * @return 
     */
    @Override
    public String geefBeschrijving() {
        return ijsje.geefBeschrijving() + ", slagroom";
    }
    
    /**
     * Deze functie returned de oude prijs van het ijsje plus de 50 cent voor de slagroom.
     * @return 
     */
    @Override
    public int prijs(){
        return super.prijs() + 50;
    }
    
}
