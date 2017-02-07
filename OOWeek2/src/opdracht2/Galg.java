/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opdracht2;

/**
 *
 * @author Lisa Tostrams s4386167
 * model klasse
 */
public class Galg {
    private StringBuilder woord = new StringBuilder(); 
    private StringBuilder current = new StringBuilder(); 
    private int geraden = 0; 
    
    /**
     * constructor met parameter
     * @param woord 
     */
    public Galg(String woord) {
        this.woord.append(woord); 
        for(int i = 0; i < woord.length(); i++) {
            current.append(".");
        }
    }
    
    /**
     * constructor zonder parameter
     */
    public Galg() {
        WoordLezer woordlezer = new WoordLezer("woorden.txt"); 
        woord.append(woordlezer.geefWoord());  
        System.out.println(woord.toString());
         for(int i = 0; i < woord.length(); i++) {
            current.append(".");
        }
    }
    
    /**
     * 
     * @return woord goed geraden 
     */
    public boolean guessedRight() {
        return current.toString().equals(woord.toString()); 
    }
    
    /**
     * voeg letter toe aan geraden woord
     * @param x
     * @return correcte letter
     */
    public boolean letterGuess(String x) {
        int i = woord.indexOf(x);
        if(i != -1) {
            while (i != -1) {
                current.setCharAt(i, x.charAt(0));
                i = woord.indexOf(x,i+1); 
            }
            return true; 
        }
        geraden++; 
        return false; 
    }
    
    /**
     * 
     * @return hoe het geraden woord er nu uitziet 
     */
    public String getCurrent() {
        if(isDead()) return woord.toString();
        return current.toString(); 
    }
    
    /**
     * 
     * @return hoeveel pogingen er nog over zijn 
     */
    public int getGuesses(){
        return (10-geraden); 
    }
    
    /**
     * 
     * @return of hangman dood is :(  
     */
    public boolean isDead() {
        return !(geraden < 10); 
    }
}
