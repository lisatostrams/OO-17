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
public class TweekeuzeVraag extends MeerkeuzeVraag{
    
    //private String antwoord1;
    //private String antwoord2;
    private String[] antwoorden;
    private int juisteAntwoord;
    
    public TweekeuzeVraag(String vraag, String antwoord1, String antwoord2, int juisteantwoord, int gewicht) {
        super(vraag, new String [] {antwoord1, antwoord2} ,juisteantwoord, gewicht);
    }
    
    public TweekeuzeVraag(String vraag, String antwoord1, String antwoord2, int juisteantwoord){
        super(vraag, new String [] {antwoord1, antwoord2} ,juisteantwoord);
    }

    @Override
    public boolean isCorrect(String antwoord) {
        return antwoorden[juisteAntwoord].equalsIgnoreCase(antwoord);
    }

    @Override
    public String juisteAntwoord() {
        return antwoorden[juisteAntwoord];
    }
    
    @Override
    public Vraag duplicate(){
        return this;
    }
}
