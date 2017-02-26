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
   
    public Vraag(String vraag, String antwoord, int gewicht){
        this.vraag = vraag;
        this.antwoord = antwoord; 
        this.gewicht = gewicht;
    }
    public Vraag(String vraag, String antwoord){
        this.vraag = vraag;
        this.antwoord = antwoord; 
        this.gewicht = 3;
    }
    @Override
    public String toString(){
        return vraag;
    }
   public boolean isCorrect(String antwoord) {
        return antwoord.equalsIgnoreCase(this.antwoord); 
    }
    
    public String juisteAntwoord() {
        return this.antwoord;
    }

    public Vraag duplicate() {
       return this; 
    }
    public int getGewicht(){
        return gewicht;
    }
}
