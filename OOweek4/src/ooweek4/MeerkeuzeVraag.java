/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooweek4;

import java.util.Random;

/**
 *
 * @author Maurice Swanenberg s4331095
 * @author Lisa Tostrams s4386167
 * Meerkeuze vraag subklasse
 */
public class MeerkeuzeVraag extends Vraag{
    
    String [] antwoorden;
    private int juisteAntwoord;
    
    public MeerkeuzeVraag(String vraag, String[] antwoorden, int juisteantwoord, int gewicht){
        super(vraag,(""+((char) (97+juisteantwoord))), gewicht);
        this.antwoorden = antwoorden;
        this.juisteAntwoord = juisteantwoord;
    }
    
    public MeerkeuzeVraag(String vraag, String[] antwoorden, int juisteantwoord){
        super(vraag,(""+((char) (97+juisteantwoord))));
        this.antwoorden = antwoorden;
        this.juisteAntwoord = juisteantwoord;
    }
    @Override
    public String toString() {
        String options = this.vraag + "\n";
        for(int i = 0; i < antwoorden.length; i++) {
            options += (((char) (97+i)) + " : " + antwoorden[i] + "\n"); 
        }
        return options; 
    }
  

    public String getAntwoord(int i){
        return antwoorden[i];
    }
    @Override
    public String juisteAntwoord() {
        return antwoorden[juisteAntwoord];
    }
    
      /**
     * duplicate functie die ook de antwoorden shift
     * @return 
     */
    @Override
    public Vraag duplicate() {
        Random random = new Random();
        int shift = random.nextInt(this.antwoorden.length-1); 
        int shiftx = shift; 
        while(shift > 0) {
            String temp = antwoorden[antwoorden.length-1];
            for(int i = antwoorden.length-2; i >= 0; i--) {
                antwoorden[i+1] = antwoorden[i]; 
            }
            antwoorden[0] = temp; 
            shift--; 
        }
        this.juisteAntwoord = (this.juisteAntwoord+shiftx)%(this.antwoorden.length); 
        this.antwoord = "" + ((char) (97+juisteAntwoord)); 
        return this;
    }
}
