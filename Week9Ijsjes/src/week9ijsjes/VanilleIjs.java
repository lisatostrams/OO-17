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
public class VanilleIjs extends Ijsje{

    /**
     * De constructor van VanilleIjs die de beschrijving van onbekend ijsje in VanilleIjs verandert.
     */
    public VanilleIjs(){
        beschrijving = "VanilleIjs";
    }
    
    /**
     * Deze functie returned de prijs van een standaard vanille ijsje.
     * @return 
     */
    @Override
    public int prijs() {
        return 150;
    }
}
