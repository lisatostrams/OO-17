/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooweek4;

/**
 *
 * @author Maurice Swanenberg s4331095
 * @author Lisa Tostrams s4386167
 * Vraag super klasse
 */
public abstract class Vraag {
    
    int gewicht;
    String vraag;
    String antwoord; 
    
    /**
     * Dit is de constructor van Vraag die een vraag aanmaakt met een meegegeven gewicht.
     * @param vraag
     * @param antwoord
     * @param gewicht 
     */
    public Vraag(String vraag, String antwoord, int gewicht){
        this.vraag = vraag;
        this.antwoord = antwoord; 
        this.gewicht = gewicht;
    }
    
    /**
     * Dit is de constructor van Vraag die een vraag aanmaakt zonder een meegegeven gewicht.
     * @param vraag
     * @param antwoord 
     */
    public Vraag(String vraag, String antwoord){
        this.vraag = vraag;
        this.antwoord = antwoord; 
        this.gewicht = 3;
    }
    
    /**
     * De toString wordt nu gebruikt om de String vraag te returnen.
     * @return 
     */
    @Override
    public String toString(){
        return vraag;
    }
    
    /**
     * Deze boolean returned of het meegegeven antwoord hetzelfde is als het daadwerkelijke antwoord.
     * @param antwoord
     * @return 
     */
    public boolean isCorrect(String antwoord) {
        return antwoord.equalsIgnoreCase(this.antwoord); 
    }
    
    /**
     * Deze functie returned het juiste antwoord
     * @return 
     */
    public String juisteAntwoord() {
        return this.antwoord;
    }

    /**
     * Deze functie returned het hele object Vraag.
     * @return 
     */
    public Vraag duplicate() {
       return this; 
    }
    
    public int getGewicht(){
        return gewicht;
    }
}
