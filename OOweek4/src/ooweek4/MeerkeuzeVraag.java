/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooweek4;

/**
 *
 * @author mauri
 */
public class MeerkeuzeVraag extends Vraag{
    
    private String [] antwoorden;
    private int juisteAntwoord;
    
    public MeerkeuzeVraag(String vraag, String[] antwoorden, int juisteantwoord, int gewicht){
        super(vraag,gewicht);
        this.antwoorden = antwoorden;
        this.juisteAntwoord = juisteantwoord;
    }
    
    public MeerkeuzeVraag(String vraag, String[] antwoorden, int juisteantwoord){
        super(vraag);
        this.antwoorden = antwoorden;
        this.juisteAntwoord = juisteantwoord;
    }

    @Override
    public boolean isCorrect(String antwoord) {
        return antwoord.equalsIgnoreCase(antwoorden[juisteAntwoord]);
    }

    public String getAntwoord(int i){
        return antwoorden[i];
    }
    @Override
    public String juisteAntwoord() {
        return antwoorden[juisteAntwoord];
    }
    
}
