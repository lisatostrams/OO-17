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
public class YoghurtIjs extends Ijsje{

    /**
     * De constructor van YoghurtIjs die de beschrijving van onbekend ijsje in YoghurtIjs verandert.
     */
    public YoghurtIjs(){
        beschrijving = "YoghurtIjs";
    }
    
    /**
     * Deze functie returned de prijs van een standaard yoghurt ijsje.
     * @return 
     */
    @Override
    public int prijs() {
        return 200;
    }
}
