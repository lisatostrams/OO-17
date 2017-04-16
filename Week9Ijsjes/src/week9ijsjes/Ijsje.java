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
 * 
 */
public abstract class Ijsje {
    protected String beschrijving =  "onbekend ijsje";
    /**
     * Dit is een abstracte functie die een int moet returnen, die de prijs van een ijsje representeert.
     * @return 
     */
    public abstract int prijs();
    /**
     * Deze functie returned de beschrijving van een ijsje.
     * @return 
     */
    public String geefBeschrijving(){
        return beschrijving;
    }
}
